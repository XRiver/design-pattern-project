package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

public class MapDataManagerV1 implements MapDataManager {
     private static MapDataManager instance = new MapDataManagerV1();
     private MapDataManagerV1() {
     }

    public Tour loadTour(TourId id) {
        return null;
    }

    public static MapDataManager getInstance() {
         return instance;
     }
}
