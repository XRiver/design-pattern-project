package nju.riverxu.ds.model.spirit.hero;


import nju.riverxu.ds.model.item.Consumable;
import nju.riverxu.ds.model.item.Skill;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.AttackInfo;
import nju.riverxu.ds.model.spirit.AttackResult;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.effect.Effect;
import nju.riverxu.ds.model.tour.Tour;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Hero extends Spirit implements OperatedCharacter {

    private HeroStatus status = null;

    //再加上各种便于计算的易变状态，包括动作状态等


    private Tour tour = null;

    public Hero(HeroStatus status, Tour tour) {
        this.status = status;
        this.tour = tour;
    }

    private void useWeapon(Weapon weapon) {

    }

    private AttackResult getDamaged(AttackInfo info) {
        return null;
    }

    private void useConsumable(int ind) {

    }

    private void useSkill(int ind) {

    }

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


    @Override
    public void act() {


    }

    // -1,0,1分别表示正在在此轴上向负方向移动/不动/向正方向移动
    private int xMoveStatus = 0, yMoveStatus = 0;

    private boolean xStill() {
        return xMoveStatus == 0;
    }

    private boolean yStill() {
        return yMoveStatus == 0;
    }

    public void startMove(Direction d) {
        switch (d) {
            case EAST:
                if (xStill()) xMoveStatus = 1;
                break;
            case WEST:
                if (xStill()) xMoveStatus = -1;
                break;
            case NORTH:
                if (yStill()) yMoveStatus = -1;
                break;
            case SOUTH:
                if (yStill()) yMoveStatus = 1;
                break;
        }
    }

    public void stopMove(Direction d) {
        switch (d) {
            case EAST:
                if (xMoveStatus == 1) xMoveStatus = 0;
                break;
            case WEST:
                if (xMoveStatus == -1) xMoveStatus = 0;
                break;
            case NORTH:
                if (yMoveStatus == -1) yMoveStatus = 0;
                break;
            case SOUTH:
                if (yMoveStatus == 1) yMoveStatus = 0;
                break;
        }
    }


    private ActionSlot prevTryingToUse;
    private boolean usingLeftHand = false;
    private boolean usingRightHand = false;

    // boolean为true表示“开始动作”，false表示“结束动作”
    private ConcurrentLinkedQueue<Triplet<ActionSlot, Boolean, Long>> actionCommands =
            new ConcurrentLinkedQueue<Triplet<ActionSlot, Boolean, Long>>();

    public void startUse(ActionSlot a) {
        actionCommands.add(new Triplet<ActionSlot, Boolean, Long>(a, true, frame.get()));
    }

    public void stopUse(ActionSlot a) {
        actionCommands.add(new Triplet<ActionSlot, Boolean, Long>(a, false, frame.get()));
    }

    public void interact() {
        tour.getCurrent().interact(this);
    }

    private void die() {
        active = false;
        tour.end(Tour.DIED);
    }
}
