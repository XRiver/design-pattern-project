package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.spirit.hero.HeroStatus;
import nju.riverxu.ds.util.SerializeHelper;

import java.io.File;

public class SaveManagerDebug implements SaveManager {
    public boolean hasPrevSave() {
        File f1 = new File(HERO_STATUS_FILENAME);
        File f2 = new File(MISSION_STATUS_FILENAME);

        return f1.exists() && f2.exists();
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
