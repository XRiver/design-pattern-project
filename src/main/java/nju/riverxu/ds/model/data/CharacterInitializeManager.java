package nju.riverxu.ds.model.data;

import nju.riverxu.ds.controller.CharacterInitController;

public interface CharacterInitializeManager {
    InitialHero[] getTypes();
    void useType(InitialHero selected);
}
