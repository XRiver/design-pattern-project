package nju.riverxu.ds.model.tour;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tour implements Serializable {
    private static ExecutorService spiritThreadPool = Executors.newCachedThreadPool();
    private transient Dungeon current;
    private Dungeon[] dungeons;

    private TourId id;

    public Tour(Dungeon[] dungeons, TourId id) {
        this.dungeons = dungeons;
        this.id = id;

        current = dungeons[0];
    }

    public TourId getId() {
        return id;
    }

    public Dungeon getCurrent() {
        return current;
    }
}
