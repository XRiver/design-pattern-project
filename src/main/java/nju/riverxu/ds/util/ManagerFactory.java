package nju.riverxu.ds.util;

import nju.riverxu.ds.model.StatusManager;
import nju.riverxu.ds.model.TourManager;
import nju.riverxu.ds.model.data.CharacterInitializeManager;
import nju.riverxu.ds.model.data.MapDataManager;
import nju.riverxu.ds.model.data.SaveManager;

public abstract class ManagerFactory {

    public abstract SaveManager makeSaveManager();

    public abstract TourManager makeTourManager();

    public abstract StatusManager makeStatusManager();

    public abstract CharacterInitializeManager makeCharacterInitializeManager();

    public abstract MapDataManager makeMapDataManager();

    public static ManagerFactory getInstance(ManagerFactoryVersion version) {
        if(version==ManagerFactoryVersion.V1) {
            return new ManagerFactoryV1();
        } else if (version==ManagerFactoryVersion.DEBUG) {
            return new ManagerFactoryDebug();
        } else {
            return null;
        }
    }
}
