package nju.riverxu.ds.model.spirit;

import nju.riverxu.ds.model.item.ArmorSuite;
import nju.riverxu.ds.model.item.ConsumableSkillSuite;
import nju.riverxu.ds.model.item.ItemSuite;
import nju.riverxu.ds.model.item.WeaponSuite;

import java.io.Serializable;

public interface HeroStatus extends Serializable {
    ItemSuite getItemSuite();

    ArmorSuite getArmorSuite();

    ConsumableSkillSuite getConsumableSkillSuite();

    WeaponSuite getWeaponSuite();

    int getAttr(StatusType type);

    void setAttr(StatusType type, int attr);
}
