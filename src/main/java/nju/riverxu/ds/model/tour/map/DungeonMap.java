package nju.riverxu.ds.model.tour.map;

import java.util.List;

public interface DungeonMap {
    List<MapElement> getElements();
    void loadAllElements(DungeonMap prototype);
    void addElement(MapElement element);
}
