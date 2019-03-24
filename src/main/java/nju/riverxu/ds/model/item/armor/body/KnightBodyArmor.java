package nju.riverxu.ds.model.item.armor.body;

import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.armor.BodyArmor;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KnightBodyArmor extends BodyArmor {

    public String getName() {
        return "骑士胸甲";
    }

    public double getWeight() {
        return 0;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return new ItemUpgradeInfo(true,this,3000);
    }

    public boolean upgrade() {
        //TODO
        return false;
    }
}
