package nju.riverxu.ds.model.tour.map;

import nju.riverxu.ds.model.tour.Location;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public interface DungeonMap extends Serializable {
    Iterator<MapElement> getStaticElementsIter();
    Iterator<MobInfo> getMobInfoIter();
    Location getHeroInitialLocation();
    DungeonMapSize getSize();
}
