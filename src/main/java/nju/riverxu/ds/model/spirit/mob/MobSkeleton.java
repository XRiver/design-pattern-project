package nju.riverxu.ds.model.spirit.mob;

import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.AttackInfo;
import nju.riverxu.ds.model.spirit.AttackResult;
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

    @Override
    public void act() {
        //TODO 检查视野并尝试追逐、攻击主角
    }

    public int soulCount() {
        return 500;
    }

    private void die() {
        hp = 0.0;
        active = false;
    }
}
