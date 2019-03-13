package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

/**
 * 从地图数据加载指定的Tour
 */
public interface MapDataManager {
    Tour loadTour(TourId id);
}
