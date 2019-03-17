package nju.riverxu.ds.model.spirit;

import java.io.Serializable;

public abstract class Spirit implements Runnable, Serializable {

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
