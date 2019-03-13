package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.spirit.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

import java.io.Serializable;

interface Item extends Serializable {
    void use(Dungeon dungeon, Hero hero);
    String getName();
    double getWeight();
}
