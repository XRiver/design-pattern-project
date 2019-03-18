package nju.riverxu.ds.model;

import nju.riverxu.ds.controller.TourController;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.Observable;

public interface TourManager extends Observable {

    void startNewTour(StatusManager statusManager, TourId tourId);

    TourController getHeroController();

    Tour getCurrentTour();
}
