package nju.riverxu.ds.util;

import nju.riverxu.ds.model.save.SaveManager;

/**
 * DPHint: AbstractFactory
 */
public abstract class ManagerFactory {

    public abstract SaveManager makeSaveManager();

    public static ManagerFactory getInstance(ManagerFactoryVersion version) {
        if(version==ManagerFactoryVersion.V1) {
            return new ManagerFactoryV1();
        } else {
            return null;
        }
    }
}
