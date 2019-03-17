package nju.riverxu.ds.model.item;


import java.io.Serializable;
import java.util.Arrays;

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

    public Consumable[] getConsumableArray() {
        return consumables;
    }

    public Skill[] getSkillArray() {
        return skills;
    }


    private String getAvailableConsumables() {
        StringBuilder sb = new StringBuilder();
        for(Consumable c: consumables) {
            if(c!= null) {
                sb.append(c.getName()+" ");
            }
        }
        return sb.toString();
    }

    private String getAvailableSkills() {
        StringBuilder sb = new StringBuilder();
        for(Skill s:skills) {
            if(s!=null) {
                sb.append(s.getName()+" ");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "消耗品与法术套装{" +
                "消耗品=" + getAvailableConsumables() +
                ", 法术=" + getAvailableSkills() +
                '}';
    }
}
