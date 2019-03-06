package nju.riverxu.ds.model;


import nju.riverxu.ds.controller.HeroController;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏model核心类，单例
 *
 * 控制游戏状态：开始前/冒险中/升级中（各种篝火行为）
 *
 * 由于某些Controller所控制的model对象在游戏过程中会动态创建、删除、替换的，
 * 所以在需要时，View要从本类获取新的Controller(Listener)
 *
 * Game为GameController所操纵的model，可以“开始游戏”、“启动某关卡”等
 *
 *
 */
public class Game implements Observable {

    private static Game instance = new Game();

    private TourManager tourManager = null;
    private StatusManager statusManager = null;

    private GameStatus gameStatus = GameStatus.INITING;

    private Game(){
        //TODO
        ManagerFactory mf = ManagerFactory.getInstance(ManagerFactoryVersion.V1);

        //tourManager = new TourManager();
        //statusManager = new StatusManager();
    }

    public static Game getInstance() {
        return instance;
    }

    public TourManager getTourManager() {
        return tourManager;
    }

    public StatusManager getStatusManager() {
        return statusManager;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void startGame() {
        //TODO
        gameStatus = GameStatus.UPGRADE;
    }

    public void startTour(TourId id) {
        //TODO delegate to TourManager
        gameStatus = GameStatus.TOUR;
    }





    /*下面这段到处copy-paste就好*/
    private List<Observer> observers = new ArrayList<Observer>();
    public void addObserver(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAll(EventType eventType, Object event) {
        for(Observer ob: observers) {
            ob.notifyEvent(eventType, event);
        }
    }
}
