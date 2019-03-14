package nju.riverxu.ds.model.tour.map;

import nju.riverxu.ds.model.tour.Location;

public class Wall implements MapElement {

    private Location pt1, pt2;
    private boolean isSolid;

    public Wall(Location pt1, Location pt2, boolean isSolid) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.isSolid = isSolid;
    }

    public Location getPt1() {
        return pt1;
    }

    public Location getPt2() {
        return pt2;
    }

    public boolean isSolid() {
        return isSolid;
    }
}
