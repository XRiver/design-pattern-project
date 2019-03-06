package nju.riverxu.ds.model.spirit;

import nju.riverxu.ds.model.Spirit;
import nju.riverxu.ds.model.Tour;

public class Hero extends Spirit {

    private HeroStatus status = null;
    
    private Tour tour = null;

    public Hero(HeroStatus status, Tour tour) {
        this.status = status;

    }

    public void run() {
        while (active) {

        }
    }


}
