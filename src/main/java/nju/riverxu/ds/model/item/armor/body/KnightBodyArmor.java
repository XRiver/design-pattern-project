package nju.riverxu.ds.model.item.armor.body;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.armor.BodyArmor;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KnightBodyArmor extends BodyArmor {

    public String getName() {
        return "骑士胸甲" + (level > 0 ? "+" + level : "");
    }

    public double getWeight() {
        return 15.0;
    }

    private int level = 0;

    public ItemUpgradeInfo getUpgradeInfo() {
        if (level < 3) {
            return new ItemUpgradeInfo(true, this, 3000 + 1000 * level);
        } else {
            return ItemCantUpgradeInfo.getInstance();
        }
    }

    public boolean upgrade() {
        if (level < 3) {
            level += 1;
            return true;
        }
        return false;
    }
}
