package nju.riverxu.ds.model.item;


import java.io.Serializable;

public class ConsumableSkillSuite implements Serializable {
    private Consumable[] consumables = null;
    private Skill[] skills = null;

    public static final int CONSUMABLE_MAX_SLOT = 5;
    public static final int SKILL_MAX_SLOT = 5;

    public ConsumableSkillSuite() {
        consumables = new Consumable[CONSUMABLE_MAX_SLOT];
        skills = new Skill[SKILL_MAX_SLOT];
    }

    public Consumable getConsumable(int index) {
        if(index < CONSUMABLE_MAX_SLOT) {
            return consumables[index];
        } else {
            return null;
        }
    }

    public void setConsumable(int index, Consumable c) {
        if(index < CONSUMABLE_MAX_SLOT) {
            consumables[index] = c;
        }
    }

    public Skill getSkill(int index) {
        if (index < SKILL_MAX_SLOT) {
            return skills[index];
        } else {
            return null;
        }
    }

    public void setSkill(int index, Skill s) {
        if (index < SKILL_MAX_SLOT) {
            skills[index] = s;
        }
    }

}
