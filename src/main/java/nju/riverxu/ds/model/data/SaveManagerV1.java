package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.spirit.hero.HeroStatus;

/**
 * 简单的存档管理,使用json序列化相关对象作为字符串文件存在固定位置
 */
public class SaveManagerV1 implements SaveManager{

    private static SaveManagerV1 instance = new SaveManagerV1();
    private SaveManagerV1(){
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

    public boolean saveHeroStatus(HeroStatus saved) {
        return false;
    }

    public boolean saveMissionStatus(MissionStatus saved) {
        return false;
    }
}
