package nju.riverxu.ds.model.item.weapon;

import nju.riverxu.ds.model.item.Weapon;

public abstract class Shield extends Weapon {
    public abstract double getBlockeDamage(double rawDamage);
}
