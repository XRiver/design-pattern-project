package nju.riverxu.ds.model.tour;

public class TourId {
    private int id;
    private String name;
    private boolean isPlayable;

    public TourId(int id, String name, boolean isPlayable) {
        this.id = id;
        this.name = name;
        this.isPlayable = isPlayable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPlayable() {
        return isPlayable;
    }
}
