package nju.riverxu.ds.model;

import nju.riverxu.ds.model.item.Item;
import nju.riverxu.ds.model.spirit.hero.HeroStatus;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.spirit.hero.SuiteEnum;
import nju.riverxu.ds.model.spirit.hero.UpgradeInfo;
import nju.riverxu.ds.util.Observable;

public interface UpgradeManager extends Observable {

    UpgradeInfo getUpgradeInfo();

    boolean upgradeAttr(StatusType target);

    boolean upgradeItem(Item item);

    boolean moveItem(SuiteEnum fromSuite, int fromSlot, SuiteEnum toSuite, int toSlot);

    HeroStatus getHeroStatus();

    void refreshSave();
}
