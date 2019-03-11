package nju.riverxu.ds.model.item;

public class SkillSuite {
    private Skill[] slots = null;

    public static int MAX_SLOT = 10;

    public SkillSuite() {
        slots = new Skill[MAX_SLOT];
    }

    public Skill get(int index) {
        if (index < MAX_SLOT) {
            return slots[index];
        } else  {
            return null;
        }
    }

    public void set(int index, Skill s) {
        if (index < MAX_SLOT) {
            slots[index] = s;
        }
    }

}
