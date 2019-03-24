package nju.riverxu.ds.model.item.comsumable;

import nju.riverxu.ds.model.item.Consumable;
import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.tour.Dungeon;

public class HealDrug extends Consumable {

    public String getName() {
        return "生命药水";
    }

    public double getWeight() {
        return 2;
    }

    public void affect(Spirit spirit) {
        assert spirit instanceof Hero;
        Hero h = (Hero) spirit;
        h.heal(this, 80.0);
    }
}
