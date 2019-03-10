package nju.riverxu.ds.model.item;

public abstract class Armor implements Item {
    //TODO 设计成需要检查升级资源？
    public abstract boolean canUpgrade();
    public abstract void upgrade();
}
