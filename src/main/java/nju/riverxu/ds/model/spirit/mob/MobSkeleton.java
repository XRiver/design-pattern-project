package nju.riverxu.ds.model.spirit.mob;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.item.weapon.WeaponRange;
import nju.riverxu.ds.model.spirit.AttackInfo;
import nju.riverxu.ds.model.spirit.AttackResult;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Location;
import nju.riverxu.ds.util.Algorithm;

public class MobSkeleton extends Mob {

    public MobSkeleton() {
        super();
        max_hp = hp = 200.0;
    }

    public void useWeapon(Weapon w) {
        Location myLoc = d.getHeroLocation();
        Location attacked = Algorithm.getMigratedLocation(myLoc,direction,getRadius()+w.getWeaponRange().getRange());

        Hero h = d.getHero();
        Location heroLocation = d.getHeroLocation();
        if(attacked.distance(heroLocation) < h.getRadius()) {
            h.getDamaged(new AttackInfo(this, myLoc, w, null, w.getRawDamage(this)));
        }
    }

    public AttackResult getDamaged(AttackInfo info) {
        double realDamage = info.getRawDamage();

        if(hp <= realDamage) {
            die();
            return new AttackResult(true,AttackResult.EFFECTIVE, realDamage);
        } else {
            hp -= realDamage;
            return new AttackResult(false,AttackResult.EFFECTIVE,realDamage);
        }
    }

    private long lastAttack = -999;

    @Override
    public void act() {
        //检查视野并尝试追逐、攻击主角

        //检查视野太麻烦了！应该委托Dungeon来做

        //只要看英雄够不够近就好了！
        Location heroLocation = d.getHeroLocation();
        Location myLocation = d.getMobLocation(this);
        direction = Algorithm.getRelativeDirection(myLocation,heroLocation);

        if(myLocation.distance(heroLocation) < 10) { //够近
            if(frame.get()-lastAttack > DEFAULT_FRAME_PER_SEC*5) { // 攻击CD为5秒
                useWeapon(myWeapon);
                lastAttack = frame.get();
            }
        }
    }
    private static Weapon myWeapon = new SkeletonSword();

    public int soulCount() {
        return 500;
    }

    private void die() {
        hp = 0.0;
        active = false;
    }

    static class SkeletonSword extends Weapon {

        public double getRawDamage(Spirit user) {
            return 50;
        }

        public String getName() {
            return "骷髅的剑";
        }

        public double getWeight() {
            return 10;
        }

        public ItemUpgradeInfo getUpgradeInfo() {
            return ItemCantUpgradeInfo.getInstance();
        }

        public boolean upgrade() {
            return false;
        }

        private static WeaponRange r = new WeaponRange(10);
        @Override
        public WeaponRange getWeaponRange() {
            return r;
        }
    }
}
