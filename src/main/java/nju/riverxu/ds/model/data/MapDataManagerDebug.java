package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.SerializeHelper;

import java.io.*;

public class MapDataManagerDebug implements MapDataManager {
    private static MapDataManager instance = new MapDataManagerDebug();
    private MapDataManagerDebug() {}
    public static MapDataManager getInstance() {
        return instance;
    }

    public Tour loadTour(TourId id) {
        Object[] read = SerializeHelper.readAll("tour"+id.getId()+".data");
        if (read != null) {
            return (Tour) read[0];
        } else {
            return null;
        }
    }
}
