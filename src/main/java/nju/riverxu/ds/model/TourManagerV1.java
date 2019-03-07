package nju.riverxu.ds.model;

import nju.riverxu.ds.controller.HeroController;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

public class TourManagerV1 implements TourManager {

    private static TourManager instance = new TourManagerV1();
    public static TourManager getInstance() {
        return instance;
    }

    private Tour current = null;

    private TourManagerV1(){
        //TODO
    }

    public void startNewTour(StatusManager statusManager, TourId tourId) {

    }

    public HeroController getHeroController() {
        return null;
    }
}
