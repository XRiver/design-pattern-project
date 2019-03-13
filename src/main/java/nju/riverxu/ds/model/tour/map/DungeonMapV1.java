package nju.riverxu.ds.model.tour.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DungeonMapV1 implements DungeonMap {

    private LinkedList<MapElement> elements = null;

    public DungeonMapV1() {
        elements = new LinkedList<MapElement>();
    }

    public List<MapElement> getElements() {
        return new ArrayList<MapElement>(elements);
    }

//    public void addElement(MapElement element) {
//        elements.add(element);
//    }
}
