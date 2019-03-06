package nju.riverxu.ds.model;

import nju.riverxu.ds.controller.HeroController;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

public class TourManager {
    private Tour current = null;

    public TourManager() {

    }

    public void startNewTour(StatusManager statusManager, TourId tourId) {

    }


    public HeroController getHeroController() {
        //TODO delegate to Tour
        return null;
    }
}
