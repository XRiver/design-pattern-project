package nju.riverxu.ds.model.spirit.hero;

public enum ActionSlot {
    RIGHT_HAND(1), LEFT_HAND(0),
    SKILL_1(1), SKILL_2(2), SKILL_3(3), SKILL_4(4), SKILL_5(5),
    CONS_1(1), CONS_2(2), CONS_3(3), CONS_4(4), CONS_5(5);

    ActionSlot(int ind) {
        this.ind = ind;
    }
    private int ind;
    public int getInd() {return ind;}
}
