package nju.riverxu.ds.model;

import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.Observable;

import java.util.List;

public interface StatusManager extends Observable {
    List<TourId> getTourList();
}
