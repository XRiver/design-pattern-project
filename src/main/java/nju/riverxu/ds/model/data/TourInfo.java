package nju.riverxu.ds.model.data;

import java.io.Serializable;

public class TourInfo implements Serializable {
    private boolean unlocked;
    private int attemptTimes;
    private int completeTimes;

    public TourInfo(boolean unlocked, int attemptTimes, int completeTimes) {
        this.unlocked = unlocked;
        this.attemptTimes = attemptTimes;
        this.completeTimes = completeTimes;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public int getAttemptTimes() {
        return attemptTimes;
    }

    public void setAttemptTimes(int attemptTimes) {
        this.attemptTimes = attemptTimes;
    }

    public int getCompleteTimes() {
        return completeTimes;
    }

    public void setCompleteTimes(int completeTimes) {
        this.completeTimes = completeTimes;
    }
}
