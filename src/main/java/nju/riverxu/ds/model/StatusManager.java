package nju.riverxu.ds.model;

import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.Observable;

public interface StatusManager extends Observable {
    TourId[] getTourList();
    UpgradeManager getUpgradeManager();
}
