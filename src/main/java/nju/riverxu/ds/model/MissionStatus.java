package nju.riverxu.ds.model;

import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.model.tour.TourId;

import java.io.Serializable;

/**
 * 关卡总列表信息
 * 关卡Tour解锁、关卡通过次数等关卡相关信息
 */
public class MissionStatus implements Serializable {

    private TourId[] tourIdArray;
    private TourInfo[] infoArray;

    public MissionStatus(TourId[] tourIdArray, TourInfo[] infoArray) {
        this.tourIdArray = tourIdArray;
        this.infoArray = infoArray;
    }

    public TourId[] getTourIdList() {
        return tourIdArray;
    }

    public TourInfo[] getInfoArray() {
        return infoArray;
    }

    class TourInfo implements Serializable {
        boolean unlocked;
        int attemptTimes;
        int completeTimes;

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
}
