package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.hero.StatusType;

public class Dagger extends Weapon {

    public String getName() {
        return "盗贼短刀";
    }

    public double getWeight() {
        return 5;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }

    public boolean upgrade() {
        return false;
    }

    public double getRawDamage(Spirit user) {
        if(user instanceof Hero) {
            return 40+((Hero) user).getStatus().getAttr(StatusType.STR)*0.5;
        }
        return 40.0;
    }
}
