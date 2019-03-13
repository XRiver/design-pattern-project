package nju.riverxu.ds.model;


import nju.riverxu.ds.controller.GameController;
import nju.riverxu.ds.model.data.SaveManager;
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
    //TODO not DEBUG!
    public static final ManagerFactoryVersion VERSION = ManagerFactoryVersion.DEBUG;

    private static Game instance = new Game();
    public static Game getInstance() {
        return instance;
    }

    private TourManager tourManager = null;
    private StatusManager statusManager = null;
    private SaveManager saveManager = null;

    private GameState gameState = GameState.GAME_INITING;

    private Game(){

        ManagerFactory mf = ManagerFactory.getInstance(VERSION);

        tourManager = mf.makeTourManager();
        statusManager = mf.makeStatusManager();
        saveManager = mf.makeSaveManager();

    }

    public GameController getGameController() {
        return new GameController();
    }

    public boolean canContinueFromSave() {
        return saveManager.hasPrevSave();
    }

    public void startGame(boolean withPrevSave) {
        if (withPrevSave) {
            gameState = GameState.UPGRADE;
            notifyAll(EventType.GAME_STARTING, null);
        } else {
            gameState = GameState.CHARACTER_INITING;
            notifyAll(EventType.GAME_STARTING, null);
        }
    }


    public TourManager getTourManager() {
        return tourManager;
    }

    public StatusManager getStatusManager() {
        return statusManager;
    }

    public GameState getGameState() {
        return gameState;
    }


    public void startTour(TourId id) {
        //TODO delegate to TourManager
        gameState = GameState.TOUR;
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
