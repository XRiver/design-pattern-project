package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.tour.Dungeon;

public class WoodStick extends Weapon {
    public String getName() {
        return "棍棒";
    }

    public double getWeight() {
        return 8;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }

    public boolean upgrade() {
        return false;
    }

    public double getRawDamage(Spirit user) {
        if(user instanceof Hero) {
            return 45+((Hero) user).getStatus().getAttr(StatusType.STR)*1.3;
        }
        return 45.0;
    }
}
