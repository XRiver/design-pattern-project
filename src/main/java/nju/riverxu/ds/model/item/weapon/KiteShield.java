package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KiteShield extends Shield {


    public String getName() {
        return "鸢形盾";
    }

    public double getWeight() {
        return 10.0;
    }

    private int level = 0;

    public ItemUpgradeInfo getUpgradeInfo() {
        return new ItemUpgradeInfo(true,this,1500);
    }

    public boolean upgrade() {
        return false;
    }

    public double getRawDamage(Spirit user) {
        return 0;
    }
}
