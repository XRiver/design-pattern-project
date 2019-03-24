package nju.riverxu.ds.model.spirit.mob;


import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.AttackInfo;
import nju.riverxu.ds.model.spirit.AttackResult;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.effect.Effect;
import nju.riverxu.ds.model.spirit.Direction;
import nju.riverxu.ds.model.tour.Dungeon;

import java.util.LinkedList;
import java.util.List;

public abstract class Mob extends Spirit {

    protected double max_hp, hp;
    protected Direction direction = Direction.NORTH;

    @Override
    public void act() {

    }

    public abstract void useWeapon(Weapon w);
    public abstract AttackResult getDamaged(AttackInfo info);

    List<Effect> activeEffects = new LinkedList<Effect>();
    public Effect hasEffect(Class<? extends Effect> c) {
        for (Effect e : activeEffects) {
            if (e.getClass() == c) {
                return e;
            }
        }
        return null;
    }
    public void addEffect(Effect e) {
        activeEffects.add(e);
    }
    public void removeEffect(Effect e) {
        activeEffects.remove(e);
    }

    public abstract int soulCount();

    protected transient Dungeon d;
    public void setDungeon(Dungeon d) {this.d = d;}
}
