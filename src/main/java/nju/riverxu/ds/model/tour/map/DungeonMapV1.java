package nju.riverxu.ds.model.tour.map;

import nju.riverxu.ds.model.tour.Location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DungeonMapV1 implements DungeonMap {

    private DungeonMapSize size = null;
    private List<MapElement> elements = null;
    private List<MobInfo> mobs = null;
    private Location heroInitialLocation = null;

    public DungeonMapV1(List<MapElement> elements, List<MobInfo> mobs, Location heroInitialLocation, DungeonMapSize size) {
        this.elements = elements;
        this.mobs = mobs;
        this.heroInitialLocation = heroInitialLocation;
        this.size = size;
    }

    public Iterator<MapElement> getStaticElementsIter() {
        return elements.iterator();
    }

    public Iterator<MobInfo> getMobInfoIter() {
        return mobs.iterator();
    }

    public Location getHeroInitialLocation() {
        return heroInitialLocation;
    }

    public DungeonMapSize getSize() {
        return size;
    }

}
