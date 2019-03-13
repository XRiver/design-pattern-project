package nju.riverxu.ds.model.data.helper;

import nju.riverxu.ds.model.data.MissionStatus;
import nju.riverxu.ds.model.data.TourInfo;
import nju.riverxu.ds.model.tour.*;
import nju.riverxu.ds.model.tour.map.DungeonMap;
import nju.riverxu.ds.model.tour.map.DungeonMapSize;
import nju.riverxu.ds.model.tour.map.DungeonMapV1;
import nju.riverxu.ds.util.SerializeHelper;

/**
 * 本类用于生成最初的地图数据；
 * TODO 注意地图数据要与设计的MissionStatus对齐，否则MapDataManager在加载时就会遇到问题
 */
public class InitTourDataHelper {

    public static MissionStatus initMissionStatus() {
        MissionStatus ret = new MissionStatus(new TourId[]{
                new TourId(1,"不死聚落", new int[]{2}),
                new TourId(2,"城外不死教区", new int[0])
        }, new TourInfo[] {
                new TourInfo(true,0,0),
                new TourInfo(false,0,0)
        });
        return ret;
    }

    private static Tour makeTour1() {
        Dungeon[] dungeons = new Dungeon[2];

        {
            DungeonMapSize size = new DungeonMapSize(600,600);
            Location location = new Location(150,150);
            //TODO Walls, exits...... Mobs...
            DungeonMap map = null;
            Dungeon d = new Dungeon(new DungeonId(1,"不死聚落上层"),map);

            dungeons[0] = d;
        }

        {
            DungeonMap map = null;
            //TODO
            Dungeon d = new Dungeon(new DungeonId(1,"监视塔"), map);;
            dungeons[1] = d;
        }


        return new Tour(dungeons, new TourId(1,"不死聚落", new int[]{2}));
    }

    private static Tour makeTour2() {
        Dungeon[] dungeons = new Dungeon[1];

        {//D1
            DungeonMap map = null;
            //TODO
            Dungeon d = new Dungeon(new DungeonId(1,"太阳祭坛"),map);

            dungeons[0] = d;
        }

        return new Tour(dungeons, new TourId(1,"城外不死教区", new int[]{2}));
    }


    public static void main(String[] args) {
        /*
        生成两个Tour：1与2，1能解锁2
        TODO int id为i的Tour，文件生成命名为"tour{{i}}.data"
         */
        boolean ret1 = SerializeHelper.writeAll(new Object[]{makeTour1()}, "tour1.data");
        boolean ret2 = SerializeHelper.writeAll(new Object[]{makeTour2()}, "tour2.data");

        System.out.println("tour1 make&write:"+ret1);
        System.out.println("tour2 make&write:"+ret2);
    }
}
