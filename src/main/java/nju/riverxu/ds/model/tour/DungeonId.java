package nju.riverxu.ds.model.tour;

import java.io.Serializable;

public class DungeonId implements Serializable {
    private int id;
    private String name;

    public DungeonId(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
