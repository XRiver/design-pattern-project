package nju.riverxu.ds.model.spirit.hero;

import nju.riverxu.ds.model.item.ArmorSuite;
import nju.riverxu.ds.model.item.ConsumableSkillSuite;
import nju.riverxu.ds.model.item.ItemSuite;
import nju.riverxu.ds.model.item.WeaponSuite;

/**
 * 包括物品栏、装备栏在内的各种不易变状态
 */
public class HeroStatusV1 implements HeroStatus {

    private ItemSuite itemSuite = null;

    private ArmorSuite armorSuite = null;
    private ConsumableSkillSuite consumableSkillSuite = null;
    private WeaponSuite weaponSuite = null;

    private int VIT, STR, INT, level;

    public HeroStatusV1() {
        itemSuite = new ItemSuite();

        armorSuite = new ArmorSuite(null, null);
        consumableSkillSuite = new ConsumableSkillSuite();
        weaponSuite = new WeaponSuite(null, null);
    }

    public HeroStatusV1(ItemSuite itemSuite, ArmorSuite armorSuite, ConsumableSkillSuite consumableSkillSuite, WeaponSuite weaponSuite) {
        this.itemSuite = itemSuite;
        this.armorSuite = armorSuite;
        this.consumableSkillSuite = consumableSkillSuite;
        this.weaponSuite = weaponSuite;
    }

    public ItemSuite getItemSuite() {
        return itemSuite;
    }

    public ArmorSuite getArmorSuite() {
        return armorSuite;
    }

    public ConsumableSkillSuite getConsumableSkillSuite() {
        return consumableSkillSuite;
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
            case LEVEL:
                return level;
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
            case LEVEL:
                level = attr;
                break;
        }
    }

    @Override
    public String toString() {
        return "英雄状态V1{" +
                "\n物品栏=" + itemSuite +
                ", \n护甲=" + armorSuite +
                ", \n消耗品与法术=" + consumableSkillSuite +
                ", \n武器=" + weaponSuite +
                ", VIT=" + VIT +
                ", STR=" + STR +
                ", INT=" + INT +
                ", level=" + level +
                '}';
    }
}
