package nju.riverxu.ds.model.tour;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.StatusManager;
import nju.riverxu.ds.model.UpgradeManager;
import nju.riverxu.ds.model.data.MapDataManager;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.map.Exit;
import nju.riverxu.ds.model.tour.map.MapElement;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observable;
import nju.riverxu.ds.util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Tour implements Serializable, Observable {
    private static ExecutorService spiritThreadPool = Executors.newCachedThreadPool();

    private transient Dungeon current;
    private Dungeon[] dungeons;

    private Hero hero = null;

    private TourId id;

    private StatusManager statusManager;

    /**
     * 使用id进行初始化，将会运行时动态加载Dungeon及其地图
     * @param id
     * @param statusManager
     */
    public Tour(TourId id, StatusManager statusManager) {
        this.id = id;
        this.statusManager = statusManager;
        MapDataManager mapLoader = Game.getInstance().getManagerFactory().makeMapDataManager();
        Tour prototype = mapLoader.loadTour(id);

        hero = new Hero(statusManager.getUpgradeManager().getHeroStatus(), this);
        initFromPrototype(prototype);
        current = dungeons[0];
    }

    /**
     * 给InitTourDataHelper使用，不用于运行时Tour创建
     * @param dungeons
     * @param id
     */
    public Tour(Dungeon[] dungeons, TourId id) {
        this.dungeons = dungeons;
        this.id = id;
    }

    /**
     * 读取原型Tour的地图信息，初始化dungeons，包括里面的Mob
     *
     * @param t
     */
    private void initFromPrototype(Tour t) {

        dungeons = new Dungeon[t.dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            Dungeon d = new Dungeon(t.dungeons[i].getId(),t.dungeons[i].getMap());
            dungeons[i] = d;

            d.setHero(hero);
            d.setTour(this);

        }
    }

    public TourId getId() {
        return id;
    }

    public Dungeon getCurrent() {
        return current;
    }

    public Hero getHero() {
        return hero;
    }

    /**
     * 开始Tour的运行；在此之后controller才可使用
     */
    public void start() {
        runSpirit(hero);
        current.start();

        isRunning = true;
    }

    public void switchDungeon(int exitId) {
        Exit toExit = null;
        Dungeon toDungeon = null;
        for(Dungeon d:dungeons) {
            Iterator<MapElement> staticElementsIter = d.getMap().getStaticElementsIter();
            while(staticElementsIter.hasNext()) {
                MapElement element = staticElementsIter.next();
                if(element instanceof Exit) {
                    Exit e = (Exit) element;
                    if(e.getId()==exitId) {
                        toExit = e;
                        break;
                    }
                }
            }
            if(toExit!= null) {
                toDungeon = d;
            }
        }
        assert toDungeon!=null;

        current = toDungeon;
        current.setHeroLocation(toExit.getLocation());
        current.start();

        // 使用Event通知到View有关Dungeon切换的事情
        notifyAll(EventType.DUNGEON_SWITCHED, current);
    }

    public static final int SUCCESS = 1;
    public static final int GIVE_UP = 2;
    public static final int DIED = 3;
    public void end(int result) {
        UpgradeManager upgradeManager = statusManager.getUpgradeManager();

        switch (result) {
            //进行MissionStatus/HeroStatus的刷新与自动存档
            case SUCCESS:
                statusManager.completeTour(id,true);
                upgradeManager.refreshAndSave(true);
                break;
            case GIVE_UP:
                statusManager.completeTour(id,false);
                upgradeManager.refreshAndSave(true);
                break;
            case DIED:
                statusManager.completeTour(id,false);
                upgradeManager.refreshAndSave(false);
                break;
        }

        spiritThreadPool.shutdownNow();
        notifyAll(EventType.TOUR_END, this);
    }

    private boolean isRunning = false;
    public boolean isRunning() {
        return isRunning;
    }

    public Future runSpirit(Spirit s) {
        return spiritThreadPool.submit(s);
    }

    private List<Observer> observers = new ArrayList<Observer>();
    public void addObserver(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAll(EventType eventType, Object event) {
        for(Observer ob: observers) {
            ob.notifyEvent(eventType, event);
        }
    }

}
