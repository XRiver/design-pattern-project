package nju.riverxu.ds.model.spirit.hero;

import nju.riverxu.ds.model.item.ItemUpgradeInfo;

public class UpgradeInfo {
    private int nextLevelCost;
    private StatusType[] upgradableStatus;
    private ItemUpgradeInfo[] itemUpgradeInfos;

    public UpgradeInfo(int nextLevelCost, StatusType[] upgradableStatus, ItemUpgradeInfo[] itemUpgradeInfos) {
        this.nextLevelCost = nextLevelCost;
        this.upgradableStatus = upgradableStatus;
        this.itemUpgradeInfos = itemUpgradeInfos;
    }

    public int getNextLevelCost() {
        return nextLevelCost;
    }

    public StatusType[] getUpgradableStatus() {
        return upgradableStatus;
    }

    public ItemUpgradeInfo[] getItemUpgradeInfos() {
        return itemUpgradeInfos;
    }
}
