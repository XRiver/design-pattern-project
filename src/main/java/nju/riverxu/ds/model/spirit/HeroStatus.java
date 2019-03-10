package nju.riverxu.ds.model.spirit;

import nju.riverxu.ds.model.item.ArmorSuite;
import nju.riverxu.ds.model.item.ConsumableSuite;
import nju.riverxu.ds.model.item.ItemSuite;
import nju.riverxu.ds.model.item.WeaponSuite;

public interface HeroStatus {
    ItemSuite getItemSuite();

    ArmorSuite getArmorSuite();

    ConsumableSuite getConsumableSuite();

    WeaponSuite getWeaponSuite();

    int getAttr(StatusType type);

    void setAttr(StatusType type, int attr);
}
