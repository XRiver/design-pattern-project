package nju.riverxu.ds.util;

import nju.riverxu.ds.model.*;
import nju.riverxu.ds.model.data.*;

public class ManagerFactoryDebug extends ManagerFactory {
    public SaveManager makeSaveManager() {
        return new SaveManagerDebug();
    }

    public TourManager makeTourManager() {
        return TourManagerDebug.getInstance();
    }

    public StatusManager makeStatusManager() {
        return StatusManagerDebug.getInstance();
    }

    public CharacterInitializeManager makeCharacterInitializeManager() {
        return CharacterInitializeManagerDebug.getInstance();
    }

    public MapDataManager makeMapDataManager() {
        return MapDataManagerDebug.getInstance();
    }

    public UpgradeManager makeUpgradeManager() {
        return UpgradeManagerDebug.getInstance();
    }

}
