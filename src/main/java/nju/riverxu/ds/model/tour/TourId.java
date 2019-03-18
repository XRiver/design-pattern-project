package nju.riverxu.ds.model.tour;

import java.io.Serializable;
import java.util.Arrays;

public class TourId implements Serializable {
    private int id;
    private String name;
    private int[] nextUnlock;

    public TourId(int id, String name, int[] nextUnlock) {
        this.id = id;
        this.name = name;
        this.nextUnlock = nextUnlock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getNextUnlock() {
        return nextUnlock;
    }

    @Override
    public String toString() {
        return "冒险信息{" +
                "ID=" + id +
                ", 名称='" + name + '\'' +
                ", 完成可解锁的冒险=" + Arrays.toString(nextUnlock) +
                '}';
    }
}
