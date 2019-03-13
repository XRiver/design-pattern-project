package nju.riverxu.ds.model.data.helper;

import nju.riverxu.ds.model.MissionStatus;

/**
 * 本类用于生成最初的地图数据；
 * TODO 注意地图数据要与设计的MissionStatus对齐，否则MapDataManager在加载时就会遇到问题
 */
public class InitTourDataHelper {

    public static MissionStatus initMissionStatus() {
        /*
        TODO 生成对应的mission.save
         */
        return new MissionStatus(null,null);
    }


    public static void main(String[] args) {
        /*
        生成两个Tour：1与2，1能解锁2
        TODO int id为i的Tour，文件生成命名为"tour{{i}}.data"
         */
    }
}
