package nju.riverxu.ds.model.data.helper;

import nju.riverxu.ds.model.data.MissionStatus;
import nju.riverxu.ds.model.data.TourInfo;
import nju.riverxu.ds.model.spirit.mob.MobSkeleton;
import nju.riverxu.ds.model.tour.*;
import nju.riverxu.ds.model.tour.map.*;
import nju.riverxu.ds.util.SerializeHelper;

import java.util.ArrayList;
import java.util.List;

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

            List<MapElement> elements = new ArrayList<MapElement>();
            // Walls
            elements.add(new Wall(new Location(100,100), new Location(100,200), true));
            elements.add(new Wall(new Location(100,100), new Location(300,100), true));
            elements.add(new Wall(new Location(300,0), new Location(300,100), true));
            elements.add(new Wall(new Location(0,200), new Location(200,200), true));
            elements.add(new Wall(new Location(0,300), new Location(200,300), true));
            elements.add(new Wall(new Location(200,300), new Location(200,500), true));
            elements.add(new Wall(new Location(200,400), new Location(300,400), false));//SPECIAL
            elements.add(new Wall(new Location(200,500), new Location(300,500), true));
            elements.add(new Wall(new Location(300,300), new Location(300,500), true));
            elements.add(new Wall(new Location(300,200), new Location(400,300), true));
            elements.add(new Wall(new Location(300,300), new Location(400,400), true));
            elements.add(new Wall(new Location(400,0), new Location(400,300), true));
            elements.add(new Wall(new Location(500,100), new Location(600,100), true));
            elements.add(new Wall(new Location(400,400), new Location(400,500), true));
            elements.add(new Wall(new Location(400,500), new Location(500,500), true));
            elements.add(new Wall(new Location(500,100), new Location(500,500), true));
            // Exits
            elements.add(new Exit(1, new Location(10,250), Exit.LEAVE_TOUR));
            elements.add(new Exit(2, new Location(250,450), Exit.COMPLETE_TOUR));
            elements.add(new Exit(3, new Location(550,50), 4));

            List<MobInfo> mobInfoList = new ArrayList<MobInfo>();
            mobInfoList.add(new MobInfo(new MobSkeleton(), new Location(70,250)));
            mobInfoList.add(new MobInfo(new MobSkeleton(), new Location(450, 350)));
            mobInfoList.add(new MobInfo(new MobSkeleton(), new Location(450,50)));

            Location heroLocation = new Location(150,150);

            DungeonMap map = new DungeonMapV1(elements, mobInfoList, heroLocation,size);
            Dungeon d = new Dungeon(new DungeonId(1,"不死聚落上层"),map);

            dungeons[0] = d;
        }

        {
            DungeonMapSize size = new DungeonMapSize(600,600);
            List<MapElement> elements = new ArrayList<MapElement>();
            elements.add(new Exit(4, new Location(100,100), 3));
            elements.add(new Exit(5, new Location(200,200), Exit.COMPLETE_TOUR));
            DungeonMap map = new DungeonMapV1(elements, new ArrayList<MobInfo>(), null,size);
            Dungeon d = new Dungeon(new DungeonId(2,"监视塔"), map);;
            dungeons[1] = d;
        }


        return new Tour(dungeons, new TourId(1,"不死聚落", new int[]{2}));
    }

    private static Tour makeTour2() {
        Dungeon[] dungeons = new Dungeon[1];

        {//D1
            DungeonMapSize size = new DungeonMapSize(600,600);
            Location heroLocation = new Location(150,150);
            List<MapElement> elements = new ArrayList<MapElement>();
            elements.add(new Exit(1, new Location(200,200), Exit.COMPLETE_TOUR));
            DungeonMap map = new DungeonMapV1(elements, new ArrayList<MobInfo>(), heroLocation,size);

            Dungeon d = new Dungeon(new DungeonId(1,"太阳祭坛"),map);

            dungeons[0] = d;
        }

        return new Tour(dungeons, new TourId(1,"城外不死教区", new int[]{2}));
    }

    public static void createTourData() {
        /*
        int id为i的Tour，文件生成命名为"tour{{i}}.data"
         */
        boolean ret1 = SerializeHelper.writeAll(new Object[]{makeTour1()}, "tour1.data");
        boolean ret2 = SerializeHelper.writeAll(new Object[]{makeTour2()}, "tour2.data");

        System.out.println("InitTourDataHelper: tour1 make&write "+ret1);
        System.out.println("InitTourDataHelper: tour2 make&write "+ret2);
    }

    public static void main(String[] args) {
        createTourData();
    }
}
