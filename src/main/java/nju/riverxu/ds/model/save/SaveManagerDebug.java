package nju.riverxu.ds.model.save;

import nju.riverxu.ds.model.MissionStatus;
import nju.riverxu.ds.model.spirit.HeroStatus;

public class SaveManagerDebug implements SaveManager {
    public boolean hasPrevSave() {
        System.out.println("We don't have a previous save!");
        return false;
    }

    public HeroStatus loadHeroStatus() {
        return null;
    }

    public MissionStatus loadMissionStatus() {
        return null;
    }

    public void saveHeroStatus(HeroStatus saved) {

    }

    public void saveMissionStatus(MissionStatus saved) {

    }
}
