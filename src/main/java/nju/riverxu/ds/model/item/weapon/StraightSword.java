package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.tour.Dungeon;

public class StraightSword extends Weapon {

    public String getName() {
        return "直剑"+(level>0?"+"+level:"");
    }

    public double getWeight() {
        return 10;
    }

    private int level = 0;

    public ItemUpgradeInfo getUpgradeInfo() {
        if(level == 2) {
            return ItemCantUpgradeInfo.getInstance();
        } else {
            return new ItemUpgradeInfo(true,this,2000+level*1);
        }
    }

    public boolean upgrade() {
        if(level < 2) {
            level += 1;
            return true;
        } else {
            return false;
        }
    }

    public double getRawDamage(Spirit user) {
        if(user instanceof Hero) {
            return 70+((Hero) user).getStatus().getAttr(StatusType.STR)*1.0+level*15.0;
        }
        return 65.0;
    }
}
