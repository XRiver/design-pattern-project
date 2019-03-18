package nju.riverxu.ds.model.tour;

import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.mob.Mob;
import nju.riverxu.ds.model.tour.map.DungeonMap;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observable;
import nju.riverxu.ds.util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dungeon implements Observable,Serializable {

    /**
     * 只有这两个field会被序列化
     */
    private DungeonId id;
    private DungeonMap map;

    private transient Hero hero = null;
    private transient Location heroLocation = null;
    private transient HashMap<Mob,Location> mobLocationHashMap = null;

    private transient Tour tour = null;

    public Dungeon(DungeonId id, DungeonMap map) {
        this.id = id;
        this.map = map;
    }

    public DungeonMap getMap() {
        return map;
    }

    public DungeonId getId() {
        return id;
    }


    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setHeroLocation(Location heroLocation) {
        this.heroLocation = heroLocation;
    }

    /**
     *
     */
    public void start() {
        //TODO 启动除了英雄以外的Spirit，也就是Mob；Hero由Tour负责启动
    }

    private boolean isRunning = false;
    public boolean isRunning() {
        return isRunning;
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

    //TODO 根据需要发送“地图改变的消息”，也可使按照时间（帧数）控制
    public void notifyAll(EventType eventType, Object event) {
        for(Observer ob: observers) {
            ob.notifyEvent(eventType, event);
        }
    }

}
