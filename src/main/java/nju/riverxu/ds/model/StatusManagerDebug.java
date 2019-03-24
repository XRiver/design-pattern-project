package nju.riverxu.ds.model;

import nju.riverxu.ds.model.data.MissionStatus;
import nju.riverxu.ds.model.data.SaveManager;
import nju.riverxu.ds.model.data.TourInfo;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StatusManagerDebug implements StatusManager {
    private static StatusManager instance = new StatusManagerDebug();
    public static StatusManager getInstance() {
        return instance;
    }

    private Game game = null;
    private UpgradeManager upgradeManager = null;

    private StatusManagerDebug() {
        game = Game.getInstance();
        tryLoadMissionStatus();
    }

    private void tryLoadMissionStatus() {
        SaveManager saveManager = game.getManagerFactory().makeSaveManager();
        if(missionStatus==null && saveManager.hasPrevSave()) {
            missionStatus = saveManager.loadMissionStatus();
        }
    }

    private MissionStatus missionStatus;

    public TourId[] getTourIds() {
        tryLoadMissionStatus();
        return missionStatus.getTourIdArray();
    }

    public UpgradeManager getUpgradeManager() {
        if (upgradeManager==null) {
            upgradeManager = game.getManagerFactory().makeUpgradeManager();
        }

        return upgradeManager;
    }

    public TourId[] getUnlockedTourIds() {
        tryLoadMissionStatus();
        List<TourId> unlocked = new LinkedList<TourId>();
        for(int i=0;i<missionStatus.getTourIdArray().length;i++) {
            if(missionStatus.getInfoArray()[i].isUnlocked()) {
                unlocked.add(missionStatus.getTourIdArray()[i]);
            }
        }
        return unlocked.toArray(new TourId[0]);
    }

    public void completeTour(TourId id, boolean success) {
        SaveManager saveManager = game.getManagerFactory().makeSaveManager();
        for(int unlockId:id.getNextUnlock()) {

            TourInfo tourInfo = missionStatus.getInfoArray()[unlockId];
            tourInfo.setAttemptTimes(tourInfo.getAttemptTimes()+1);
            if(success) {
                tourInfo.setUnlocked(true);
                tourInfo.setCompleteTimes(tourInfo.getCompleteTimes()+1);
            }
        }
        saveManager.saveMissionStatus(missionStatus);
    }


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
