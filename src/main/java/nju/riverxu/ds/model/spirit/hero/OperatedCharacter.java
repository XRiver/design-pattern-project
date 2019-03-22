package nju.riverxu.ds.model.spirit.hero;

public interface OperatedCharacter {
    void startMove(Direction d);
    void stopMove(Direction d);
    void startUse(ActionSlot a);
    void stopUse(ActionSlot a);
    void interact();
}
