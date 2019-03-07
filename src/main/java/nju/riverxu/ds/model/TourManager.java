package nju.riverxu.ds.model;

import nju.riverxu.ds.controller.HeroController;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

public interface TourManager {

    void startNewTour(StatusManager statusManager, TourId tourId);

    HeroController getHeroController();
}
