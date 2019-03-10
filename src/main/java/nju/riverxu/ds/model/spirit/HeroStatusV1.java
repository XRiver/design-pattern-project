package nju.riverxu.ds.model.spirit;

import nju.riverxu.ds.model.item.ArmorSuite;
import nju.riverxu.ds.model.item.ConsumableSuite;
import nju.riverxu.ds.model.item.ItemSuite;
import nju.riverxu.ds.model.item.WeaponSuite;

/**
 * TODO
 * 包括物品栏、装备栏在内的各种不易变状态
 * 本类的设计视为游戏核心机制，不会修改需求
 */
public class HeroStatusV1 implements HeroStatus {

    private ItemSuite itemSuite = null;


    private ArmorSuite armorSuite = null;
    private ConsumableSuite consumableSuite = null;
    private WeaponSuite weaponSuite = null;

    private int VIT, STR, INT;

    public HeroStatusV1() {

    }

    public HeroStatusV1(ItemSuite itemSuite, ArmorSuite armorSuite, ConsumableSuite consumableSuite, WeaponSuite weaponSuite) {
        this.itemSuite = itemSuite;
        this.armorSuite = armorSuite;
        this.consumableSuite = consumableSuite;
        this.weaponSuite = weaponSuite;
    }

    public ItemSuite getItemSuite() {
        return itemSuite;
    }

    public ArmorSuite getArmorSuite() {
        return armorSuite;
    }

    public ConsumableSuite getConsumableSuite() {
        return consumableSuite;
    }

    public WeaponSuite getWeaponSuite() {
        return weaponSuite;
    }

    public int getAttr(StatusType type) {
        switch (type) {
            case STR:
                return STR;
            case VIT:
                return VIT;
            case INT:
                return INT;
            default:
                return 0;
        }
    }

    public void setAttr(StatusType type, int attr) {
        switch (type) {
            case STR:
                STR = attr;
                break;
            case VIT:
                VIT = attr;
                break;
            case INT:
                INT = attr;
                break;
        }
    }
}
