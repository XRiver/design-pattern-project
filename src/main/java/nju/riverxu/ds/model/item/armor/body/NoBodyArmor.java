package nju.riverxu.ds.model.item.armor.body;

import nju.riverxu.ds.model.item.armor.BodyArmor;

public class NoBodyArmor extends BodyArmor {
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
