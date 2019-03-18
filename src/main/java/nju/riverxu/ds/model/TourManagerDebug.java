package nju.riverxu.ds.model;

import nju.riverxu.ds.controller.TourController;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.List;

public class TourManagerDebug implements TourManager {

    private static TourManager instance = new TourManagerDebug();
    public static TourManager getInstance() {
        return instance;
    }

    private Tour current = null;

    private TourManagerDebug(){
        //TODO
    }

    public void startNewTour(StatusManager statusManager, TourId tourId) {

    }

    public TourController getHeroController() {
        return null;
    }

    public Tour getCurrentTour() {
        return current;
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
