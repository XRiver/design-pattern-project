package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

import java.io.*;

public class MapDataManagerDebug implements MapDataManager {
    private static MapDataManager instance = new MapDataManagerDebug();
    private MapDataManagerDebug() {
        //TODO
    }
    public static MapDataManager getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        MapDataManager m = MapDataManagerDebug.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("status.save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeObject(m.getTypes());
            oos.close();
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("status.save");
            ObjectInputStream ios = new ObjectInputStream(fis);
            //InitialHero[] read = (InitialHero[])ios.readObject();
            ios.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tour loadTour(TourId id) {
        //TODO
        return null;
    }
}
