package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class StraightSword extends Weapon {
    public boolean canUpgrade() {
        return false;
    }

    public void upgrade() {

    }

    public void use(Dungeon dungeon, Hero hero) {

    }

    public String getName() {
        return null;
    }

    public double getWeight() {
        return 0;
    }
}
