package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KiteShield extends Shield {


    public String getName() {
        if(level==0) {
            return "鸢形盾";
        } else {
            return "强化鸢形盾";
        }

    }

    public double getWeight() {
        return 10.0;
    }

    private int level = 0;

    public ItemUpgradeInfo getUpgradeInfo() {
        if(level==0) {
            return new ItemUpgradeInfo(true,this,1500);
        } else {
            return ItemCantUpgradeInfo.getInstance();
        }

    }

    public boolean upgrade() {
        if(level==0) {
            level+=1;
            return true;
        }
        return false;
    }

    public double getRawDamage(Spirit user) {
        return 0;
    }

    public double getBlockeDamage(double rawDamage) {
        if(level==0) {
            return 0.2*rawDamage;
        } else {
            return 0.05*rawDamage;
        }
    }
}
