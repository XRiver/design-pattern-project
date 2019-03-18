package nju.riverxu.ds.model;

import nju.riverxu.ds.model.data.MissionStatus;
import nju.riverxu.ds.model.spirit.hero.HeroStatus;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.List;

public class StatusManagerV1 implements StatusManager {

    private static StatusManager instance = new StatusManagerV1();
    public static StatusManager getInstance() {
        return instance;
    }

    private StatusManagerV1() {
        //TODO
    }

    private HeroStatus heroStatus;

    private MissionStatus missionStatus;

    public TourId[] getTourIds() {
        return null;
    }

    public UpgradeManager getUpgradeManager() {
        return null;
    }

    public TourId[] getUnlockedTourIds() {
        return new TourId[0];
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
