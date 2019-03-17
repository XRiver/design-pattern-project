package nju.riverxu.ds.model.item;

public class ItemCantUpgradeInfo extends ItemUpgradeInfo {
    private static ItemUpgradeInfo instance = new ItemCantUpgradeInfo();
    public static ItemUpgradeInfo getInstance() {
        return instance;
    }
    private ItemCantUpgradeInfo() {
        super(false, null, 0);
    }
}
