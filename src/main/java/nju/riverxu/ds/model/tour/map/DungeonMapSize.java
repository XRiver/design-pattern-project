package nju.riverxu.ds.model.tour.map;

import java.io.Serializable;

public class DungeonMapSize implements Serializable {

    private int x,y;

    public DungeonMapSize(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
