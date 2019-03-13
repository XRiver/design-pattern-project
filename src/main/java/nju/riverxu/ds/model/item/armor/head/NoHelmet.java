package nju.riverxu.ds.model.item.armor.head;

import nju.riverxu.ds.model.item.armor.Helmet;
import nju.riverxu.ds.model.spirit.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class NoHelmet extends Helmet {
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
