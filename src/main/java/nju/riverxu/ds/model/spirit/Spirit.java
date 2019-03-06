package nju.riverxu.ds.model.spirit;

public abstract class Spirit implements Runnable {

    protected boolean active = true;
    public void setActive(boolean active) {
        this.active = active;
    }

}
