package nju.riverxu.ds.model.item;

import java.io.Serializable;

public class ItemSuite implements Serializable {
    private Item[] slots = null;
    public static int MAX_SLOT = 99;

    public ItemSuite() {
        slots = new Item[MAX_SLOT];
    }

    public Item get(int index) {
        if (index < MAX_SLOT) {
            return slots[index];
        } else {
            return null;
        }
    }

    public void set(int index, Item i) {
        if (index < MAX_SLOT) {
            slots[index] = i;
        }
    }
}
