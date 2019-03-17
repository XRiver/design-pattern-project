package nju.riverxu.ds.model.item;

import java.io.Serializable;
import java.util.Arrays;

public class ItemSuite implements Serializable {
    private Item[] slots = null;
    public static final int MAX_SLOT = 99;
    private int soulCount = 0;

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

    public int getSoulCount() {
        return soulCount;
    }

    public void setSoulCount(int soulCount) {
        this.soulCount = soulCount;
    }

    public Item[] getArray() {
        return slots;
    }

    private String availableItems() {
        StringBuilder sb = new StringBuilder();
        for(Item i:slots) {
            if (i!= null) {
                sb.append(i.getName()+"  ");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "物品栏{" +
                "可用物品=" + availableItems() +
                ", 灵魂量=" + soulCount +
                '}';
    }
}
