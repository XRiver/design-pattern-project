package nju.riverxu.ds.model.item.weapon;

/**
 * Demo版，“攻击范围”仅指一个点：所以本类只包含一个double，指在攻击方向上的点的距离。
 */
public class WeaponRange {
    private double range;

    public WeaponRange(double range) {
        this.range = range;
    }

    public double getRange() {
        return range;
    }
}
