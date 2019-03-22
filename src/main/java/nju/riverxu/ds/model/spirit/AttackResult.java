package nju.riverxu.ds.model.spirit;

public class AttackResult {

    public static final int EFFECTIVE = 0;
    public static final int MISSED = 1;
    public static final int BLOCKED = 2;

    private boolean killed;
    private int effect;
    private double realDamage;

    public AttackResult(boolean killed, int effect, double realDamage) {
        this.killed = killed;
        this.effect = effect;
        this.realDamage = realDamage;
    }

    public boolean isKilled() {
        return killed;
    }

    public int getEffect() {
        return effect;
    }

    public double getRealDamage() {
        return realDamage;
    }
}
