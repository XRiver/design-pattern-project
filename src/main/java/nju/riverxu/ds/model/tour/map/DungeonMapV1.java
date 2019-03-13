package nju.riverxu.ds.model.tour.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DungeonMapV1 implements DungeonMap {

    private List<MapElement> elements = null;
    private List<MobInfo> mobs = null;

    public DungeonMapV1(List<MapElement> elements, List<MobInfo> mobs) {
        this.elements = elements;
        this.mobs = mobs;
    }

    public Iterator<MapElement> getStaticElementsIter() {
        return elements.iterator();
    }

    public Iterator<MobInfo> getMobInfoIter() {
        return mobs.iterator();
    }

}
