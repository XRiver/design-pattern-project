package nju.riverxu.ds.model;

import nju.riverxu.ds.model.data.SaveManager;
import nju.riverxu.ds.model.item.*;
import nju.riverxu.ds.model.spirit.hero.HeroStatus;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.spirit.hero.SuiteEnum;
import nju.riverxu.ds.model.spirit.hero.UpgradeInfo;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.ManagerFactory;
import nju.riverxu.ds.util.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UpgradeManagerDebug implements UpgradeManager {

    private HeroStatus heroStatus = null;

    private SaveManager saveManager = null;

    private static UpgradeManager instance = new UpgradeManagerDebug();
    public static UpgradeManager getInstance() {
        return instance;
    }
    private UpgradeManagerDebug() {
        Game game = Game.getInstance();
        ManagerFactory mf = game.getManagerFactory();
        saveManager = mf.makeSaveManager();

        loadHeroStatus();
    }
    private void loadHeroStatus() {
        assert saveManager.hasPrevSave();
        heroStatus = saveManager.loadHeroStatus();
    }

    private int calcSoul(int currentLevel) {
        return (currentLevel-12) * 50;
    }

    public UpgradeInfo getUpgradeInfo() {

        if (heroStatus==null) {
            assert Game.getInstance().getGameState() == GameState.UPGRADE;
            loadHeroStatus();
        }

        refreshAndSave(true);

        int soulCount = heroStatus.getItemSuite().getSoulCount();
        int level = heroStatus.getAttr(StatusType.LEVEL);
        int neededSoul = calcSoul(level);

        if(soulCount >= neededSoul) {
            return new UpgradeInfo(neededSoul, new StatusType[] {StatusType.STR,StatusType.VIT,StatusType.INT},
                    getUpgradableItemInfo(soulCount));
        } else {
            return new UpgradeInfo(neededSoul, new StatusType[0], getUpgradableItemInfo(soulCount));
        }
    }

    private ItemUpgradeInfo[] getUpgradableItemInfo(int soulCount) {
        List<ItemUpgradeInfo> l = new LinkedList<ItemUpgradeInfo>();

        iterateArrayAndCheckUpgradable(heroStatus.getItemSuite().getArray(),l,soulCount);
        iterateArrayAndCheckUpgradable(heroStatus.getArmorSuite().getArray(),l,soulCount);
        iterateArrayAndCheckUpgradable(heroStatus.getWeaponSuite().getArray(),l,soulCount);
        iterateArrayAndCheckUpgradable(heroStatus.getConsumableSkillSuite().getConsumableArray(),l,soulCount);
        iterateArrayAndCheckUpgradable(heroStatus.getConsumableSkillSuite().getSkillArray(),l,soulCount);



        return l.toArray(new ItemUpgradeInfo[0]);
    }

    private void iterateArrayAndCheckUpgradable(Item[] arr, List<ItemUpgradeInfo> l, int soulCount) {
        for(Item i:arr) {
            if(i!=null) {
                ItemUpgradeInfo info = i.getUpgradeInfo();
                if(info.isUpgradable()&&info.getNeededSoul()<=soulCount) {
                    l.add(info);
                }
            }
        }
    }

    public boolean upgradeAttr(StatusType target) {
        UpgradeInfo info = getUpgradeInfo();
        for(StatusType t:info.getUpgradableStatus()) {
            if(t==target) {
                ItemSuite suite = heroStatus.getItemSuite();
                suite.setSoulCount(suite.getSoulCount()-info.getNextLevelCost());
                heroStatus.setAttr(t,heroStatus.getAttr(t)+1);
                heroStatus.setAttr(StatusType.LEVEL, heroStatus.getAttr(StatusType.LEVEL)+1);

                notifyAll(EventType.UPGRADE_SUCCESS,null);
                return true;
            }
        }
        return false;
    }

    public boolean upgradeItem(Item item) {
        ItemUpgradeInfo itemUpgradeInfo = item.getUpgradeInfo();
        int soulCount = heroStatus.getItemSuite().getSoulCount();
        if(itemUpgradeInfo.isUpgradable() && itemUpgradeInfo.getNeededSoul() <= soulCount) {
            item.upgrade();
            heroStatus.getItemSuite().setSoulCount(soulCount-itemUpgradeInfo.getNeededSoul());

            notifyAll(EventType.UPGRADE_SUCCESS,null);
            return true;
        }
        return false;
    }

    /**
     * 为了编码方便一些，不会检查参数正确与否！错误调用可能会使存档发生难以修复的错误。
     * @param fromSuite
     * @param fromSlot
     * @param toSuite
     * @param toSlot
     * @return
     */
    public boolean moveItem(SuiteEnum fromSuite, int fromSlot, SuiteEnum toSuite, int toSlot) {

        Item item = null;
        try {
            switch (fromSuite) {
                case ITEM:
                    item = heroStatus.getItemSuite().get(fromSlot);
                    heroStatus.getItemSuite().set(fromSlot, null);
                    break;
                case WEAPON:
                    item = heroStatus.getWeaponSuite().get(fromSlot);
                    heroStatus.getWeaponSuite().set(fromSlot,null);
                    break;
                case COMSUMABLE:
                    item = heroStatus.getConsumableSkillSuite().getConsumable(fromSlot);
                    heroStatus.getConsumableSkillSuite().setConsumable(fromSlot,null);
                    break;
                case SKILL:
                    item = heroStatus.getConsumableSkillSuite().getSkill(fromSlot);
                    heroStatus.getConsumableSkillSuite().setSkill(fromSlot,null);
                    break;
                case ARMOR:
                    item = heroStatus.getArmorSuite().get(fromSlot);
                    heroStatus.getArmorSuite().set(fromSlot,null);
                    break;
            }

            switch (toSuite) {
                case ITEM:
                    heroStatus.getItemSuite().set(toSlot,item);
                    break;
                case WEAPON:
                    heroStatus.getWeaponSuite().set(toSlot,(Weapon) item);
                    break;
                case COMSUMABLE:
                    heroStatus.getConsumableSkillSuite().setConsumable(toSlot, (Consumable) item);
                    break;
                case SKILL:
                    heroStatus.getConsumableSkillSuite().setSkill(toSlot,(Skill)item);
                    break;
                case ARMOR:
                    heroStatus.getArmorSuite().set(toSlot,(Armor) item);
                    break;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * 除了处理冒险逻辑的model，其他方法应只读本返回对象，不应修改。
     * @return
     */
    public HeroStatus getHeroStatus() {
        if (heroStatus==null) {
            loadHeroStatus();
        }
        return heroStatus;
    }

    public void refreshAndSave(boolean survived) {
        //TODO 应当对于Skill的使用次数进行刷新。但是Demo版暂时不包括此功能。

        if(!survived) { // Lose souls
            heroStatus.getItemSuite().setSoulCount(0);
        }
        saveManager.saveHeroStatus(heroStatus);
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
