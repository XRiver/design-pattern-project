package nju.riverxu.ds.model.item;

public class ItemUpgradeInfo {
    boolean upgradable;
    Item item;
    int neededSoul;

    public ItemUpgradeInfo(boolean upgradable, Item item, int neededSoul) {
        this.upgradable = upgradable;
        this.item = item;
        this.neededSoul = neededSoul;
    }

    public boolean isUpgradable() {
        return upgradable;
    }

    public Item getItem() {
        return item;
    }

    public int getNeededSoul() {
        return neededSoul;
    }

    @Override
    public String toString() {
        return "升级项：{" +
                "可升级 =" + upgradable +
                ", 物品 =" + item.getName() +
                ", 所需灵魂 =" + neededSoul +
                '}';
    }
}
