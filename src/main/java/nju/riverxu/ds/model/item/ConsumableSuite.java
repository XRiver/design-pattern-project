package nju.riverxu.ds.model.item;


public class ConsumableSuite {
    private Consumable[] slots = null;

    public static int MAX_SLOT = 10;

    public ConsumableSuite() {
        slots = new Consumable[MAX_SLOT];
    }

    public Consumable get(int index) {
        if(index < MAX_SLOT) {
            return slots[index];
        } else {
            return null;
        }
    }

    public void set(int index, Consumable c) {
        if(index < MAX_SLOT) {
            slots[index] = c;
        }
    }

}
