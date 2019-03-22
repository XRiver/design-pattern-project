package nju.riverxu.ds.model.tour.map;

import nju.riverxu.ds.model.tour.Location;

import java.io.Serializable;

public interface MapElement extends Serializable {
    double distance(Location l);
}
