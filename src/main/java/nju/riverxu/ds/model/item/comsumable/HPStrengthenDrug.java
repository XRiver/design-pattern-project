package nju.riverxu.ds.model.item.comsumable;

import nju.riverxu.ds.model.item.Consumable;
import nju.riverxu.ds.model.spirit.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class HPStrengthenDrug extends Consumable {
    public void use(Dungeon dungeon, Hero hero) {
        //TODO
    }

    public String getName() {
        return "生命值上限强化药水";
    }

    public double getWeight() {
        return 2;
    }
}
