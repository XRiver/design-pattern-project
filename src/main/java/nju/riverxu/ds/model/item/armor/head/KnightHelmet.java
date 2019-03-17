package nju.riverxu.ds.model.item.armor.head;

import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.armor.Helmet;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KnightHelmet extends Helmet {

    public void use(Dungeon dungeon, Hero hero) {

    }

    public String getName() {
        return "骑士头盔";
    }

    public double getWeight() {
        return 0;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        //TODO
        return new ItemUpgradeInfo(true,this,2500);
    }

    public boolean upgrade() {
        return false;
    }
}
