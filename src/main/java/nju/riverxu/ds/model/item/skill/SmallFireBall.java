package nju.riverxu.ds.model.item.skill;

import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Skill;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class SmallFireBall extends Skill {


    public void use(Dungeon dungeon, Hero hero) {

    }

    public String getName() {
        return null;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        //TODO
        return new ItemUpgradeInfo(true,this,5000);
    }

    public boolean upgrade() {
        return false;
    }
}
