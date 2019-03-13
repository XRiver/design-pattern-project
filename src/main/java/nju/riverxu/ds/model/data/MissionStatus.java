package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.data.TourInfo;
import nju.riverxu.ds.model.tour.TourId;

import java.io.Serializable;

/**
 * 关卡总列表信息
 * 关卡Tour解锁、关卡通过次数等关卡相关信息
 */
public class MissionStatus implements Serializable {

    // 两个数组一样长
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

}
