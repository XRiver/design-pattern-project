package nju.riverxu.ds.model.item;

public abstract class Consumable implements Item {

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }

    public boolean upgrade() {
        return false;
    }
}
