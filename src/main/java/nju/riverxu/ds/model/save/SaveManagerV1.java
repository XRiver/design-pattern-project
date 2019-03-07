package nju.riverxu.ds.model.save;

import nju.riverxu.ds.model.MissionStatus;
import nju.riverxu.ds.model.spirit.HeroStatus;

/**
 * 简单的存档管理,使用json序列化相关对象作为字符串文件存在固定位置
 */
public class SaveManagerV1 implements SaveManager{

    private static SaveManagerV1 instance = new SaveManagerV1();
    private SaveManagerV1(){
        //TODO
    }
    public static SaveManager getInstance() {
        return instance;
    }

    public boolean hasPrevSave() {
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
