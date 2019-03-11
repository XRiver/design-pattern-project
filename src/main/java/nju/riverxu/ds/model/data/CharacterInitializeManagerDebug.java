package nju.riverxu.ds.model.data;

import nju.riverxu.ds.util.ManagerFactory;
import nju.riverxu.ds.util.ManagerFactoryVersion;


public class CharacterInitializeManagerDebug implements CharacterInitializeManager {

    private static CharacterInitializeManager instance = new CharacterInitializeManagerDebug();
    public static CharacterInitializeManager getInstance() {
        return instance;
    }

    public InitialHero[] getTypes() {
        //TODO
        return new InitialHero[0];
    }

    public void useType(InitialHero selected) {
        ManagerFactory.getInstance(ManagerFactoryVersion.DEBUG).makeSaveManager().saveHeroStatus(selected.getStatus());
    }
}
