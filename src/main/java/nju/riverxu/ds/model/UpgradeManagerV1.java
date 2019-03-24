package nju.riverxu.ds.model;

import nju.riverxu.ds.model.item.Item;
import nju.riverxu.ds.model.spirit.hero.HeroStatus;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.spirit.hero.SuiteEnum;
import nju.riverxu.ds.model.spirit.hero.UpgradeInfo;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.List;

public class UpgradeManagerV1 implements UpgradeManager {
    public UpgradeInfo getUpgradeInfo() {
        return null;
    }

    public boolean upgradeAttr(StatusType target) {
        return false;
    }

    public boolean upgradeItem(Item item) {
        return false;
    }

    public boolean moveItem(SuiteEnum fromSuite, int fromSlot, SuiteEnum toSuite, int toSlot) {
        return false;
    }

    public HeroStatus getHeroStatus() {
        return null;
    }

    public void refreshAndSave(boolean survived) {

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
