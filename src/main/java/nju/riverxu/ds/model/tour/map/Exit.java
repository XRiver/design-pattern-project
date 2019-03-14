package nju.riverxu.ds.model.tour.map;

import nju.riverxu.ds.model.tour.Location;

public class Exit implements MapElement {

    public static final int LEAVE_TOUR = -1;
    public static final int COMPLETE_TOUR = -2;

    private int id;

    private Location location;
    private int leadTo; // Another exit's id or LEAVE_TOUR or COMPLETE_TOUR

    public Exit(int id, Location location, int leadTo) {
        this.id = id;
        this.location = location;
        this.leadTo = leadTo;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public int getLeadTo() {
        return leadTo;
    }
}
