package nju.riverxu.ds.model.spirit.hero;


import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.tour.Tour;

public class Hero extends Spirit implements OperatedCharacter{

    private HeroStatus status = null;

    //再加上各种便于计算的易变状态，包括动作状态等


    private Tour tour = null;

    public Hero(HeroStatus status, Tour tour) {
        this.status = status;
        this.tour = tour;
    }




    @Override
    public void act() {

    }


    public void startMove(Direction d) {

    }

    public void stopMove(Direction d) {

    }

    public void startUse(ActionSlot a) {

    }

    public void stopUse(ActionSlot a) {

    }

    public void interact() {

    }
}
