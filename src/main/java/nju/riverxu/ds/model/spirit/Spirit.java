package nju.riverxu.ds.model.spirit;

public abstract class Spirit implements Runnable {

    protected boolean active = true;
    public void setActive(boolean active) {
        this.active = active;
    }
    public abstract void act();
    /*
    DPHint: TemplateMethod
     */

    public void run() {
        while(active) {
            act();
        }
    }
}
