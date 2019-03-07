package nju.riverxu.ds.model;

import nju.riverxu.ds.model.spirit.HeroStatus;
import nju.riverxu.ds.model.tour.TourId;

import java.util.List;

public class StatusManagerV1 implements StatusManager {

    private static StatusManager instance = new StatusManagerV1();
    public static StatusManager getInstance() {
        return instance;
    }

    private StatusManagerV1() {
        //TODO
    }

    private HeroStatus heroStatus;

    private MissionStatus missionStatus;

    public List<TourId> getTourList() {
        return null;
    }
}
