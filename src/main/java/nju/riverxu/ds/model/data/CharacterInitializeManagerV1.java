package nju.riverxu.ds.model.data;

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

    }
}
