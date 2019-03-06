package nju.riverxu.ds.util;

import nju.riverxu.ds.model.save.JsonV1SaveManager;
import nju.riverxu.ds.model.save.SaveManager;

public class ManagerFactoryV1 extends ManagerFactory {
    public SaveManager makeSaveManager() {
        return JsonV1SaveManager.getInstance();
    }
}
