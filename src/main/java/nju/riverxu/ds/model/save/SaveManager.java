package nju.riverxu.ds.model.save;

import nju.riverxu.ds.model.MissionStatus;
import nju.riverxu.ds.model.spirit.HeroStatus;

public interface SaveManager {
    HeroStatus loadHeroStatus();
    MissionStatus loadMissionStatus();
    void saveHeroStatus(HeroStatus saved);
    void saveMissionStatus(MissionStatus saved);
}
