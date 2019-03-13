package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.spirit.HeroStatus;
import nju.riverxu.ds.util.SerializeHelper;

public class SaveManagerDebug implements SaveManager {
    public boolean hasPrevSave() {
        System.out.println("We don't have a previous save!");
        return false;
    }

    private static final String HERO_STATUS_FILENAME = "hero.save";
    private static final String MISSION_STATUS_FILENAME = "mission.save";

    public HeroStatus loadHeroStatus() {
        Object[] read = SerializeHelper.readAll(HERO_STATUS_FILENAME);
        if (read!= null) {
            return (HeroStatus)read[0];
        } else {
            return null;
        }
    }

    public MissionStatus loadMissionStatus() {
        Object[] read = SerializeHelper.readAll(MISSION_STATUS_FILENAME);
        if (read!= null) {
            return (MissionStatus)read[0];
        } else {
            return null;
        }
    }

    public boolean saveHeroStatus(HeroStatus saved) {
        return SerializeHelper.writeAll(new Object[]{saved},HERO_STATUS_FILENAME);
    }

    public boolean saveMissionStatus(MissionStatus saved) {
        return SerializeHelper.writeAll(new Object[]{saved},MISSION_STATUS_FILENAME);
    }
}
