package nju.riverxu.ds.model.tour.map;

import nju.riverxu.ds.model.spirit.Mob;
import nju.riverxu.ds.model.tour.Location;

import java.io.Serializable;

/**
 * 用于在DungeonMap中存储怪物信息，尤其适用于持久化、Dungeon初始化
 */
public class MobInfo implements Serializable {
    private Mob mob;
    private Location location;

    public MobInfo(Mob mob, Location location) {
        this.mob = mob;
        this.location = location;
    }

    public Mob getMob() {
        return mob;
    }

    public Location getLocation() {
        return location;
    }
}
