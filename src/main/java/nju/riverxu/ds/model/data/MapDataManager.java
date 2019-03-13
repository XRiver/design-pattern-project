package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.MissionStatus;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

public interface MapDataManager {
    Tour loadTour(TourId id);
}
