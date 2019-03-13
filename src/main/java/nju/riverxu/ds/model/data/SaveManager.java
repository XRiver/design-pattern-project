package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.spirit.HeroStatus;

public interface SaveManager {

    boolean hasPrevSave();

    HeroStatus loadHeroStatus();
    MissionStatus loadMissionStatus();
    boolean saveHeroStatus(HeroStatus saved);
    boolean saveMissionStatus(MissionStatus saved);
}
