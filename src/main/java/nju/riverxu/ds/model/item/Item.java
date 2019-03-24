package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

import java.io.Serializable;

public interface Item extends Serializable {

    String getName();
    double getWeight();

    ItemUpgradeInfo getUpgradeInfo();
    boolean upgrade();
}
