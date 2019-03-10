package nju.riverxu.ds.model.item;

public abstract class Skill implements Item {
    public double getWeight() {
        return 0;
    }

    //TODO 设计成需要检查升级资源？
    public abstract boolean canUpgrade();
    public abstract void upgrade();
}
