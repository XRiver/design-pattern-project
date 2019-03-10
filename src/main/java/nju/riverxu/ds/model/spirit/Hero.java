package nju.riverxu.ds.model.spirit;


import nju.riverxu.ds.model.tour.Tour;

public class Hero extends Spirit {

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
}
