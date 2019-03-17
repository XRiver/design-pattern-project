package nju.riverxu.ds.model.item.armor.head;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.armor.Helmet;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class NoHelmet extends Helmet {

    public void use(Dungeon dungeon, Hero hero) {

    }

    public String getName() {
        return null;
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
}
