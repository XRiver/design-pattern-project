package nju.riverxu.ds.model.item.armor.body;

import nju.riverxu.ds.model.item.armor.BodyArmor;
import nju.riverxu.ds.model.spirit.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class KnightBodyArmor extends BodyArmor {
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
