package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class WoodStick extends Weapon {


    public void use(Dungeon dungeon, Hero hero) {

    }

    public String getName() {
        return "棍棒";
    }

    public double getWeight() {
        return 0;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return new ItemUpgradeInfo(true,this,500);
    }

    public boolean upgrade() {
        return false;
    }
}
