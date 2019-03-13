package nju.riverxu.ds.model.tour;

import java.io.Serializable;

public class TourId implements Serializable {
    private int id;
    private String name;
    private int[] nextUnlock;

    public TourId(int id, String name, int[] nextUnlock) {
        this.id = id;
        this.name = name;
        this.nextUnlock = nextUnlock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getNextUnlock() {
        return nextUnlock;
    }
}
