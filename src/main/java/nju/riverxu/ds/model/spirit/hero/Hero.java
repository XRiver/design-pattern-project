package nju.riverxu.ds.model.spirit.hero;


import nju.riverxu.ds.model.item.*;
import nju.riverxu.ds.model.item.weapon.Shield;
import nju.riverxu.ds.model.spirit.AttackInfo;
import nju.riverxu.ds.model.spirit.AttackResult;
import nju.riverxu.ds.model.spirit.Direction;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.effect.Effect;
import nju.riverxu.ds.model.spirit.mob.Mob;
import nju.riverxu.ds.model.tour.Dungeon;
import nju.riverxu.ds.model.tour.Location;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.util.Algorithm;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.javatuples.Tuple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Hero extends Spirit implements OperatedCharacter {

    private HeroStatus status = null;

    //再加上各种便于计算的易变状态，包括动作状态等


    private Tour tour = null;

    private Direction direction = Direction.NORTH;

    public Hero(HeroStatus status, Tour tour) {
        this.status = status;
        this.tour = tour;
        init();
    }

    private void init() {
        max_hp = hp = status.getAttr(StatusType.VIT) * 10.0;
    }

    /**
     * 一般只由Hero.act()调用；也可由“攻击性法术类”（如SmallFireball）进行调用
     *
     * @param weapon
     */
    public void useWeapon(Weapon weapon) {
        Dungeon d = tour.getCurrent();
        Location myLoc = d.getHeroLocation();

        Location attacked = Algorithm.getMigratedLocation(myLoc, direction, getRadius() + weapon.getWeaponRange().getRange());
        Mob[] targets = d.getMobs(attacked, null);

        if (targets.length > 0) {
            AttackInfo attackInfo = new AttackInfo(this, myLoc, weapon, activeEffects, weapon.getRawDamage(this));
            for (Mob m : targets) {
                AttackResult attackResult = m.getDamaged(attackInfo);
                if (attackResult.isKilled()) {
                    // Add souls
                    ItemSuite itemSuite = status.getItemSuite();
                    itemSuite.setSoulCount(m.soulCount() + itemSuite.getSoulCount());
                }
            }
        }
    }

    private transient double hp, max_hp;

    public void heal(Item healBy, double amount) {
        hp = Math.min(max_hp, hp + amount);
    }

    public AttackResult getDamaged(AttackInfo info) {
        assert info.getFromSpirit() instanceof Mob;

        double realDamage = status.getArmorSuite().getRealDamage(info, this);

        if(leftHandBlocking) { // 判断攻击方向也行，但是麻烦，就不写了
            Weapon lw = status.getWeaponSuite().getLeftHand();
            if(lw instanceof Shield) {
                Shield shield = (Shield) lw;
                realDamage = shield.getBlockeDamage(realDamage); // 再减伤一次
            }
        }

        if (hp <= realDamage) {
            die();
            return new AttackResult(true, AttackResult.EFFECTIVE, realDamage);
        } else {
            hp -= realDamage;
            return new AttackResult(false, AttackResult.EFFECTIVE, realDamage);
        }
    }

    private void useConsumable(int ind) {
        Consumable c = status.getConsumableSkillSuite().getConsumable(ind - 1);
        if (c != null) {
            c.affect(this);
        }
    }

    private void useSkill(int ind) {
        Skill s = status.getConsumableSkillSuite().getSkill(ind - 1);
        if (s != null) {
            s.affect(this);
        }
    }

    public void interact() {
        tour.getCurrent().interact(this);
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

    // Demo设定为左手只能防御，右手做各种操作（攻击、技能、消耗品）
    private boolean leftHandBlocking = false, rightHandPreparing = false;
    private Triplet<ActionSlot, Boolean, Long> rightHandBusiness = null;
    private List<Pair<ActionSlot, Long>> scheduledAction = new ArrayList<Pair<ActionSlot, Long>>();
    private int actionPtr = 0;

    @Override
    public void act() {
        // 每个动作帧的行为：
        // 移动操作；移动状态由startMove stopMove已经设置好
        frameMove();

        // 规划动作
        while (!actionCommands.isEmpty()) {
            Triplet<ActionSlot, Boolean, Long> action = actionCommands.poll();
            switch (action.getValue0()) {
                // 举盾判定，由“开始动作”触发,而且会取消右手动作
                case LEFT_HAND:
                    if (action.getValue1()) {
                        leftHandBlocking = true;
                        rightHandPreparing = false;
                    } else {
                        leftHandBlocking = false;
                    }
                    break;
                // 右手操作，由“结束动作”触发，而且会取消举盾
                case RIGHT_HAND:
                case SKILL_1:
                case SKILL_2:
                case SKILL_3:
                case SKILL_4:
                case SKILL_5:
                case CONS_1:
                case CONS_2:
                case CONS_3:
                case CONS_4:
                case CONS_5:
                    leftHandBlocking = false;
                    if (action.getValue1()) {
                        rightHandPreparing = true;
                        rightHandBusiness = action;
                    } else {
                        if (action.getValue0() == rightHandBusiness.getValue0()) {
                            // 设置5帧的动作规划延迟，有一点点Dark Soul的感觉
                            rightHandPreparing = false;
                            scheduledAction.add(new Pair<ActionSlot, Long>(action.getValue0(), action.getValue2() + 5));
                        }
                    }
                    break;
            }
        }

        // 执行动作
        while (scheduledAction.size() > actionPtr && scheduledAction.get(actionPtr).getValue1() == frame.get()) {
            Pair<ActionSlot, Long> action = scheduledAction.get(actionPtr);
            actionPtr += 1;

            long prevActionFrame = -9999;
            if (actionPtr > 0) {
                prevActionFrame = scheduledAction.get(actionPtr - 1).getValue1();
            }

            // 右手动作之间设置10帧的最小间隔
            if (action.getValue1() - prevActionFrame < 10) {
                continue; // 不允许一通乱按
            }

            switch (action.getValue0()) {
                case RIGHT_HAND:
                    useWeapon(status.getWeaponSuite().getRightHand());
                    break;
                case SKILL_1:
                case SKILL_2:
                case SKILL_3:
                case SKILL_4:
                case SKILL_5:
                    useSkill(action.getValue0().getInd());
                    break;
                case CONS_1:
                case CONS_2:
                case CONS_3:
                case CONS_4:
                case CONS_5:
                    useConsumable(action.getValue0().getInd());
                    break;
            }
        }
    }

    private void frameMove() {
        // 每帧移动距离为1
        double totald = Math.sqrt(xMoveStatus * xMoveStatus + yMoveStatus * yMoveStatus);
        Dungeon d = tour.getCurrent();
        d.move(this, new Location(xMoveStatus / totald, yMoveStatus / totald));
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


    // boolean为true表示“开始动作”，false表示“结束动作”
    private ConcurrentLinkedQueue<Triplet<ActionSlot, Boolean, Long>> actionCommands =
            new ConcurrentLinkedQueue<Triplet<ActionSlot, Boolean, Long>>();

    public void startUse(ActionSlot a) {
        actionCommands.add(new Triplet<ActionSlot, Boolean, Long>(a, true, frame.get()));
    }

    public void stopUse(ActionSlot a) {
        actionCommands.add(new Triplet<ActionSlot, Boolean, Long>(a, false, frame.get()));
    }

    public HeroStatus getStatus() {
        return status;
    }

    private void die() {
        hp = 0.0;
        active = false;
        tour.end(Tour.DIED);
    }
}
