package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.spirit.Spirit;

public abstract class Skill implements Item {
    public double getWeight() {
        return 0;
    }
    public abstract void affect(Spirit s);
}
