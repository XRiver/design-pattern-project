package nju.riverxu.ds.model;

import nju.riverxu.ds.controller.TourController;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.List;

public class TourManagerV1 implements TourManager {

    private static TourManager instance = new TourManagerV1();
    public static TourManager getInstance() {
        return instance;
    }

    private Tour current = null;

    private TourManagerV1(){
    }

    public void startNewTour(StatusManager statusManager, TourId tourId) {

    }

    public TourController getTourController() {
        return null;
    }

    public Tour getCurrentTour() {
        return current;
    }

}
