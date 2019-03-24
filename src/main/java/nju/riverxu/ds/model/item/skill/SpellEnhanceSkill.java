package nju.riverxu.ds.model.item.skill;

import nju.riverxu.ds.model.item.ItemCantUpgradeInfo;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.item.Skill;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.effect.Effect;
import nju.riverxu.ds.model.spirit.effect.SpellEnhanceEffect;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class SpellEnhanceSkill extends Skill {

    public String getName() {
        return "法术强化术";
    }

    public ItemUpgradeInfo getUpgradeInfo() {
        return ItemCantUpgradeInfo.getInstance();
    }

    public boolean upgrade() {
        return false;
    }

    public void affect(Spirit s) {
        assert s instanceof Hero;
        Hero h = (Hero) s;

        Effect e = h.hasEffect(SpellEnhanceEffect.class);

        if(e!=null) {
            ((SpellEnhanceEffect)e).incrementLevel(1);
        } else {
            h.addEffect(new SpellEnhanceEffect(1));
        }
    }
}
