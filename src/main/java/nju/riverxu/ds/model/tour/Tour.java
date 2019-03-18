package nju.riverxu.ds.model.tour;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.StatusManager;
import nju.riverxu.ds.model.data.MapDataManager;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observable;
import nju.riverxu.ds.util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tour implements Serializable, Observable, Observer {
    private static ExecutorService spiritThreadPool = Executors.newCachedThreadPool();

    private transient Dungeon current;
    private Dungeon[] dungeons;

    private Hero hero = null;

    private TourId id;

    /**
     * 使用id进行初始化，将会运行时动态加载Dungeon及其地图
     * @param id
     * @param statusManager
     */
    public Tour(TourId id, StatusManager statusManager) {
        this.id = id;
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
     * 读取原型Tour的地图信息，初始化dungeons，包括里面的Mob、MapElement
     *
     * @param t
     */
    private void initFromPrototype(Tour t) {

        dungeons = new Dungeon[t.dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            dungeons[i] = new Dungeon(t.dungeons[i].getId(),t.dungeons[i].getMap());
            dungeons[i].setHero(hero);
            dungeons[i].setTour(this);
        }
        //TODO
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


    private boolean isRunning = false;
    public boolean isRunning() {
        return isRunning;
    }

    public void runSpirit(Spirit s) {
        spiritThreadPool.submit(s);
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

    public void notifyEvent(EventType eventType, Object event) {
        //TODO 接受来自Dungeon的切换通知；切换current，让新的Dungeon start，也通知到view，让其切换Dungeon画面、更新
    }
}
