package nju.riverxu.ds.model;

import nju.riverxu.ds.model.spirit.HeroStatus;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.List;

public class StatusManagerDebug implements StatusManager {
    private static StatusManager instance = new StatusManagerDebug();
    public static StatusManager getInstance() {
        return instance;
    }

    private StatusManagerDebug() {
        //TODO
    }

    private HeroStatus heroStatus;

    private MissionStatus missionStatus;

    public List<TourId> getTourList() {
        return null;
    }

    public UpgradeManager getUpgradeManager() {
        return null;
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