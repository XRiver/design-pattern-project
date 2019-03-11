package nju.riverxu.ds.model.item.armor.head;

import nju.riverxu.ds.model.item.armor.Helmet;

public class NoHelmet extends Helmet {
    public boolean canUpgrade() {
        return false;
    }

    public void upgrade() {

    }

    public void use() {

    }

    public String getName() {
        return null;
    }

    public double getWeight() {
        return 0;
    }
}
