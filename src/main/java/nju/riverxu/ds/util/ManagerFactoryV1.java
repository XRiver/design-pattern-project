package nju.riverxu.ds.util;

import nju.riverxu.ds.model.*;
import nju.riverxu.ds.model.data.*;

public class ManagerFactoryV1 extends ManagerFactory {
    public SaveManager makeSaveManager() {
        return SaveManagerV1.getInstance();
    }

    public TourManager makeTourManager() {
        return TourManagerV1.getInstance();
    }

    public StatusManager makeStatusManager() {
        return StatusManagerV1.getInstance();
    }

    public CharacterInitializeManager makeCharacterInitializeManager() {
        return CharacterInitializeManagerV1.getInstance();
    }

    public MapDataManager makeMapDataManager() {
        return MapDataManagerV1.getInstance();
    }

    public UpgradeManager makeUpgradeManager() {
        return null;
    }


}
