package nju.riverxu.ds.model.tour.map;

import java.io.Serializable;
import java.util.List;

public interface DungeonMap extends Serializable {
    List<MapElement> getElements();
    // void addElement(MapElement element);
}
