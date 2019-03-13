package nju.riverxu.ds.model.data;

import nju.riverxu.ds.util.ManagerFactory;
import nju.riverxu.ds.util.ManagerFactoryVersion;

//TODO
public class CharacterInitializeManagerV1 implements CharacterInitializeManager {

    private static CharacterInitializeManager instance = new CharacterInitializeManagerV1();
    public static CharacterInitializeManager getInstance() {
        return instance;
    }


    public InitialHero[] getTypes() {
        return new InitialHero[0];
    }

    public void useType(InitialHero selected) {
        ManagerFactory.getInstance(ManagerFactoryVersion.V1).makeSaveManager().saveHeroStatus(selected.getStatus());
    }
}
