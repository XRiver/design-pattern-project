package nju.riverxu.ds.model.spirit;

public abstract class Spirit implements Runnable {

    protected boolean active = true;
    public void setActive(boolean active) {
        this.active = active;
    }
    public abstract void act();

    //TODO 下放到Hero与Mob，设置两者不同的响应速度可以节约一点资源？？
    public void run() {
        while(active) {
            act();
        }
    }
}
