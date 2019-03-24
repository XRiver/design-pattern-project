package nju.riverxu.ds.model.spirit.effect;

public class SpellEnhanceEffect implements Effect {
    private int level;

    public SpellEnhanceEffect(int level) {
        this.level = level;
    }

    public void incrementLevel(int by) {
        if (by > 0) {
            level += by;
        }
    }

    public int getLevel() {
        return level;
    }
}
