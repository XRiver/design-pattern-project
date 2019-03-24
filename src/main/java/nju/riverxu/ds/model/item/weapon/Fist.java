package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class Fist extends Weapon {

    public String getName() {
        return "拳头";
    }

    public double getWeight() {
        return 0;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }

    public boolean upgrade() {
        return false;
    }

    public double getRawDamage(Spirit user) {
        return 10;
    }
}
