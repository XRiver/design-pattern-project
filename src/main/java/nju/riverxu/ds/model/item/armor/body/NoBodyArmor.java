package nju.riverxu.ds.model.item.armor.body;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.armor.BodyArmor;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class NoBodyArmor extends BodyArmor {

    public boolean upgrade() {
        return false;
    }

    public String getName() {
        return "没有胸甲";
    }

    public double getWeight() {
        return 0;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }
}
