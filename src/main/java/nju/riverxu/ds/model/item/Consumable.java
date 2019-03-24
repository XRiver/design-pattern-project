package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.spirit.Spirit;

public abstract class Consumable implements Item {

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }

    public boolean upgrade() {
        return false;
    }

    public abstract void affect(Spirit spirit);
}
