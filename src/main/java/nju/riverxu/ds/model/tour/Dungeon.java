package nju.riverxu.ds.model.tour;

import nju.riverxu.ds.model.spirit.Spirit;
import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.mob.Mob;
import nju.riverxu.ds.model.tour.map.*;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observable;
import nju.riverxu.ds.util.Observer;

import java.io.Serializable;
import java.util.*;

public class Dungeon implements Observable, Serializable {

    /**
     * 只有这两个field会被序列化
     */
    private DungeonId id;
    private DungeonMap map;

    private transient Hero hero = null;
    private transient Location heroLocation = null;
    private transient HashMap<Mob, Location> mobLocationHashMap = null;

    private transient Tour tour = null;

    public Dungeon(DungeonId id, DungeonMap map) {
        this.id = id;
        this.map = map;

        mobLocationHashMap = new HashMap<Mob, Location>();

        heroLocation = map.getHeroInitialLocation();
        Iterator<MobInfo> mobInfos = map.getMobInfoIter();
        while (mobInfos.hasNext()) {
            MobInfo i = mobInfos.next();
            mobLocationHashMap.put(i.getMob(), i.getLocation());
        }
    }

    public DungeonMap getMap() {
        return map;
    }

    public DungeonId getId() {
        return id;
    }


    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setHeroLocation(Location heroLocation) {
        this.heroLocation = heroLocation;
    }

    /**
     * 搜索一个点上的或一片区域内的所有Spirit；当size为null，则为单点，否则搜索矩形区域的所有Spirit
     *
     * @param absoluteLoc size为空则是搜索的单点位置，否则指搜索矩形的x/y轴的开始顶点
     * @param size        不为空时，指矩形的x轴y轴上的长度
     * @return
     */
    public Spirit[] getSpirits(Location absoluteLoc, Location size) {
        if (size == null) {
            List<Spirit> spiritList = new LinkedList<Spirit>();
            if (heroLocation.distance(absoluteLoc) < hero.getRadius()) {
                spiritList.add(hero);
            }
            for (Map.Entry<Mob, Location> mobLocationEntry : mobLocationHashMap.entrySet()) {
                if (mobLocationEntry.getValue().distance(absoluteLoc) < mobLocationEntry.getKey().getRadius()) {
                    spiritList.add(mobLocationEntry.getKey());
                }
            }

            return spiritList.toArray(new Spirit[0]);
        } else {
            //TODO Demo版不包含AOE或类似技能??
            return new Spirit[0];
        }
    }

    public void move(Spirit spirit, Location locDiff) {
        Location l = mobLocationHashMap.get(spirit);
        if (l == null) {
            assert spirit == hero;
            l = heroLocation;
        }

        //需要与墙壁进行碰撞检测
        //简化的算法：假设locDiff移动量很小，那么只要看目标地点是否与墙重合。如果重合，则不移动；否则进行移动。
        Location target = new Location(l.getX() + locDiff.getX(), l.getY() + locDiff.getY());
        Iterator<MapElement> staticElementsIter = map.getStaticElementsIter();
        while (staticElementsIter.hasNext()) {
            MapElement mapElement = staticElementsIter.next();
            if (mapElement instanceof Wall) {
                Wall wall = (Wall) mapElement;
                if (wall.isSolid() && wall.distance(target) < spirit.getRadius()) {
                    return; // 拒绝移动
                }
            }
        }
        // 或者要碰到地图边界，就也不让移动
        DungeonMapSize border = map.getSize();
        if (target.getX() < spirit.getRadius() || target.getY() < spirit.getRadius() ||
                target.getX() + spirit.getRadius() > border.getX() || target.getY() + spirit.getRadius() > border.getY()) {
            return;
        }

        // 准许移动
        l.setX(target.getX());
        l.setY(target.getY());
    }

    /**
     * 独特的“交互”动作，由Dungeon来处理而不是Spirit自己处理；
     * 包括与Exit进行交互。
     *
     * @param s
     */
    public void interact(Spirit s) {
        // 目前版本只有hero可以进行本动作（将来应该也不会变）
        assert s == hero;
        Hero h = (Hero) s;

        //且只能与Exit进行交互（正式版应该还可以捡道具、开门之类的）
        Iterator<MapElement> staticElementsIter = map.getStaticElementsIter();
        while (staticElementsIter.hasNext()) {
            MapElement mapElement = staticElementsIter.next();
            if (mapElement instanceof Exit) {
                Exit exit = (Exit) mapElement;
                useExit(exit);
                return;
            }
        }
    }

    private void useExit(Exit e) {
        switch (e.getLeadTo()) {
            case Exit.LEAVE_TOUR:
                tour.end(Tour.GIVE_UP);
                break;
            case Exit.COMPLETE_TOUR:
                tour.end(Tour.SUCCESS);
                break;
            default:
                tour.switchDungeon(e.getLeadTo());
                break;
        }
    }

    /**
     *
     */
    public void start() {
        if (isRunning) {
            return;
        }

        //启动除了英雄以外的Spirit，也就是Mob；Hero由Tour负责启动
        for (Map.Entry<Mob, Location> entry : mobLocationHashMap.entrySet()) {
            tour.runSpirit(entry.getKey());
        }
        isRunning = true;
    }

    private boolean isRunning = false;

    public boolean isRunning() {
        return isRunning;
    }


    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    //TODO 根据需要发送“地图改变的消息”，也可使按照时间（帧数）控制
    public void notifyAll(EventType eventType, Object event) {
        for (Observer ob : observers) {
            ob.notifyEvent(eventType, event);
        }
    }

}
