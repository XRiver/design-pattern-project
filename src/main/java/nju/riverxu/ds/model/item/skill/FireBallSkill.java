package nju.riverxu.ds.model.item.skill;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Skill;
import nju.riverxu.ds.model.item.Weapon;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.effect.Effect;
import nju.riverxu.ds.model.spirit.effect.SpellEnhanceEffect;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.tour.Dungeon;

public class FireBallSkill extends Skill {

    public String getName() {
        return "火球术" + (level > 0 ? "+" + level : "");
    }

    private int level = 0;

    public int getLevel() {
        return level;
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        if (level < 1) {
            return new ItemUpgradeInfo(true, this, 500);
        } else {
            return ItemCantUpgradeInfo.getInstance();
        }
    }

    public boolean upgrade() {
        if (level < 1) {
            level = 1;
            return true;
        }
        return false;
    }

    public void affect(Spirit s) {
        assert s instanceof Hero;
        Hero h = (Hero) s;

        // 可以被强化的技能、动作自己检查强化状态
        Effect enhance = ((Hero) s).hasEffect(SpellEnhanceEffect.class);
        int enhanceLevel = 0;
        if(enhance!=null) enhanceLevel = ((SpellEnhanceEffect)enhance).getLevel();

        h.useWeapon(new FireBallWeapon(enhanceLevel));

        // 强化状态使用后消耗掉
        h.removeEffect(enhance);
    }

    class FireBallWeapon extends Weapon {

        int enhanceLevel;

        public FireBallWeapon(int enhanceLevel) {
            this.enhanceLevel = enhanceLevel;
        }

        public double getRawDamage(Spirit user) {
            assert user instanceof Hero;
            Hero h = (Hero) user;

            int intell = h.getStatus().getAttr(StatusType.VIT);

            return 30 + 4 * intell + enhanceLevel * 35 + level * 10;
        }

        public String getName() {
            if(enhanceLevel>0) {
                return enhanceLevel+"层强化"+FireBallSkill.this.getName();
            } else {
                return FireBallSkill.this.getName();
            }
        }

        public double getWeight() {
            return 0;
        }

        public ItemUpgradeInfo getUpgradeInfo() {
            return ItemCantUpgradeInfo.getInstance();
        }

        public boolean upgrade() {
            return false;
        }
    }
}
