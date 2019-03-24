package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.item.weapon.WeaponRange;
import nju.riverxu.ds.model.spirit.Spirit;

public abstract class Weapon implements Item {
    private static final WeaponRange defaultRange = new WeaponRange(8.0);

    public WeaponRange getWeaponRange() {
        return defaultRange;
    }
    public abstract double getRawDamage(Spirit user);
}
