package nju.riverxu.ds.model.item.armor.head;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.armor.Helmet;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KnightHelmet extends Helmet {
    public String getName() {
        return "骑士头盔" + (level > 0 ? "+" + level : "");
    }

    public double getWeight() {
        return 3.0;
    }

    private int level = 0;

    public ItemUpgradeInfo getUpgradeInfo() {
        if (level < 3) {
            return new ItemUpgradeInfo(true, this, 2500 + 500 * level);
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
