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
        //好像没什么需要初始化的
    }

    public void startNewTour(StatusManager statusManager, TourId tourId) {
        current = new Tour(tourId, statusManager);
        current.start();
    }

    public TourController getTourController() {
        if(current!=null) {
            if(!current.isRunning()) {
                current.start();
            }
            return new TourController(current);
        } else {
            return null;
        }
    }

    public Tour getCurrentTour() {
        return current;
    }

}
