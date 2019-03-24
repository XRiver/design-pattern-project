package nju.riverxu.ds.model.spirit;

import nju.riverxu.ds.model.item.Item;
import nju.riverxu.ds.model.spirit.effect.Effect;
import nju.riverxu.ds.model.tour.Location;

import java.util.List;

public class AttackInfo {
    private Spirit fromSpirit;
    private Location fromLocation;
    private Item usingItem;
    private List<Effect> effects;

    private double rawDamage; // 不计算受击者护甲时可造成伤害（只是为了方便计算而存在的字段，“正式版”游戏不使用此字段）

    public AttackInfo(Spirit fromSpirit, Location fromLocation, Item usingItem, List<Effect> effects, double rawDamage) {
        this.fromSpirit = fromSpirit;
        this.fromLocation = fromLocation;
        this.usingItem = usingItem;
        this.effects = effects;
        this.rawDamage = rawDamage;
    }

    public Spirit getFromSpirit() {
        return fromSpirit;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public Item getUsingItem() {
        return usingItem;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public double getRawDamage() {
        return rawDamage;
    }
}
