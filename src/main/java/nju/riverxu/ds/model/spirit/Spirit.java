package nju.riverxu.ds.model.spirit;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Spirit implements Runnable, Serializable {

    protected boolean active = true;
    protected AtomicLong frame = new AtomicLong();

    protected final int DEFAULT_FRAME_PER_SEC = 30;//默认的动作帧数；Mob可以减小此数字以节省资源
    protected int frameInterval = 1000 / DEFAULT_FRAME_PER_SEC;

    public void setActive(boolean active) {
        this.active = active;
    }
    public abstract void act();

    //下放到Hero与Mob，设置两者不同的响应速度可以节约一点资源？？调整frameInterval已达到预期效果。
    public void run() {
        while(active) {
            try {
                Thread.sleep(frameInterval);
            } catch (InterruptedException e) {
                break; // Abnormal termination. Or stopped by tour.end()
            }
            frame.incrementAndGet();
            act();
        }
    }

    public double getRadius() {
        return 5.0;
    }

    public boolean isActive() {
        return active;
    }
}
