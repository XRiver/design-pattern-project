package nju.riverxu.ds.model.tour;

import nju.riverxu.ds.model.spirit.hero.Hero;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tour implements Serializable {
    private static ExecutorService spiritThreadPool = Executors.newCachedThreadPool();
    private transient Dungeon current;
    private Dungeon[] dungeons;

    private Hero hero = null;

    private TourId id;

    //TODO Delete "Dungeon[] dungeons" and Tour load itself??
    public Tour(Dungeon[] dungeons, TourId id) {
        this.dungeons = dungeons;
        this.id = id;

        current = dungeons[0];

        //TODO init hero from using HeroStatus
    }

    public TourId getId() {
        return id;
    }

    public Dungeon getCurrent() {
        return current;
    }

    public Hero getHero() {
        return hero;
    }
}
