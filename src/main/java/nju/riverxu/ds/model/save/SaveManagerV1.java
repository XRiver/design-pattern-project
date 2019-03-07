package nju.riverxu.ds.model.save;

import nju.riverxu.ds.model.MissionStatus;
import nju.riverxu.ds.model.spirit.HeroStatus;

/**
 * 简单的存档管理
 */
public class JsonV1SaveManager implements SaveManager{

    private static JsonV1SaveManager instance = new JsonV1SaveManager();
    private JsonV1SaveManager(){
        //TODO
    }
    public static SaveManager getInstance() {
        return instance;
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
