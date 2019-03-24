package nju.riverxu.ds.model;


import nju.riverxu.ds.controller.GameController;
import nju.riverxu.ds.model.data.SaveManager;
import nju.riverxu.ds.model.tour.Tour;
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
 * Game为GameController所操纵的model，可以“开始游戏”
 */
public class Game implements Observable, Observer {

    public static final ManagerFactoryVersion VERSION = ManagerFactoryVersion.DEBUG;

    private static Game instance = new Game();
    public static Game getInstance() {
        return instance;
    }

    private ManagerFactory managerFactory = null;

    private TourManager tourManager = null;
    private StatusManager statusManager = null;
    private SaveManager saveManager = null;

    public ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    private GameState gameState = GameState.GAME_INITING;

    private Game(){

        managerFactory = ManagerFactory.getInstance(VERSION);
        saveManager = managerFactory.makeSaveManager();
    }

    public GameController getGameController() {
        return new GameController();
    }

    public boolean canContinueFromSave() {
        return saveManager.hasPrevSave();
    }

    public void startGame(boolean withPrevSave) {
        if (withPrevSave) {
            assert saveManager.hasPrevSave();

            gameState = GameState.UPGRADE;
            notifyAll(EventType.GAME_MAIN_STATUS_CHANGE, null);
        } else {
            gameState = GameState.CHARACTER_INITING;
            notifyAll(EventType.GAME_MAIN_STATUS_CHANGE, null);
        }
    }


    public TourManager getTourManager() {
        if(tourManager==null) {
            tourManager = managerFactory.makeTourManager();
        }
        return tourManager;
    }

    public StatusManager getStatusManager() {
        if(statusManager==null) {
            statusManager = managerFactory.makeStatusManager();
        }
        return statusManager;
    }

    public GameState getGameState() {
        return gameState;
    }


    public void startTour(TourId id) {
        //delegate to TourManager and listen for the Tour's end
        getTourManager().startNewTour(getStatusManager(), id);
        getTourManager().getCurrentTour().addObserver(this);
        // Tell view that tour is starting
        gameState = GameState.TOUR;
        notifyAll(EventType.GAME_MAIN_STATUS_CHANGE, null);
    }

    public void endTour(Tour tour) {
        tour.removeObserver(this);
        gameState = GameState.UPGRADE;
        notifyAll(EventType.GAME_MAIN_STATUS_CHANGE, null);
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

    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case TOUR_END:
                endTour((Tour)event);
                break;
        }
    }
}
