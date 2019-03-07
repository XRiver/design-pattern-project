package nju.riverxu.ds.util;

import nju.riverxu.ds.model.StatusManager;
import nju.riverxu.ds.model.TourManager;
import nju.riverxu.ds.model.save.SaveManager;
import nju.riverxu.ds.model.save.SaveManagerDebug;

public class ManagerFactoryDebug extends ManagerFactory {
    public SaveManager makeSaveManager() {
        return new SaveManagerDebug();
    }

    public TourManager makeTourManager() {
        return null;
    }

    public StatusManager makeStatusManager() {
        return null;
    }
}
