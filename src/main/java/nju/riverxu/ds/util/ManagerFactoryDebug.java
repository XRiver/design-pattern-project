package nju.riverxu.ds.util;

import nju.riverxu.ds.model.StatusManager;
import nju.riverxu.ds.model.StatusManagerDebug;
import nju.riverxu.ds.model.TourManager;
import nju.riverxu.ds.model.TourManagerDebug;
import nju.riverxu.ds.model.data.CharacterInitializeManager;
import nju.riverxu.ds.model.data.CharacterInitializeManagerDebug;
import nju.riverxu.ds.model.data.SaveManager;
import nju.riverxu.ds.model.data.SaveManagerDebug;

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

}
