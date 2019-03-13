package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.data.helper.InitTourDataHelper;
import nju.riverxu.ds.model.item.ArmorSuite;
import nju.riverxu.ds.model.item.ConsumableSkillSuite;
import nju.riverxu.ds.model.item.ItemSuite;
import nju.riverxu.ds.model.item.WeaponSuite;
import nju.riverxu.ds.model.item.armor.body.KnightBodyArmor;
import nju.riverxu.ds.model.item.armor.body.Shirt;
import nju.riverxu.ds.model.item.armor.head.KnightHelmet;
import nju.riverxu.ds.model.item.skill.SmallFireBall;
import nju.riverxu.ds.model.item.weapon.*;
import nju.riverxu.ds.model.spirit.HeroStatus;
import nju.riverxu.ds.model.spirit.HeroStatusV1;
import nju.riverxu.ds.model.spirit.StatusType;
import nju.riverxu.ds.util.ManagerFactory;
import nju.riverxu.ds.util.ManagerFactoryVersion;


public class CharacterInitializeManagerDebug implements CharacterInitializeManager {

    private static CharacterInitializeManager instance = new CharacterInitializeManagerDebug();
    public static CharacterInitializeManager getInstance() {
        return instance;
    }


    private InitialHero[] initTypes = null;
    private CharacterInitializeManagerDebug() {
        initTypes = new InitialHero[3];

        InitialHero knight = new InitialHero("骑士","近战专家，带有不错的武器与护甲",null);
        HeroStatus knightStatus = new HeroStatusV1(new ItemSuite(), new ArmorSuite(new KnightHelmet(), new KnightBodyArmor()),
                new ConsumableSkillSuite(),new WeaponSuite(new KiteShield(), new StraightSword()));
        knightStatus.setAttr(StatusType.STR, 15);
        knightStatus.setAttr(StatusType.VIT,12);
        knightStatus.setAttr(StatusType.INT, 8);
        knightStatus.setAttr(StatusType.LEVEL, 30);
        knight.setStatus(knightStatus);
        initTypes[0] = knight;

        InitialHero caster = new InitialHero("咒术师", "能够通过远程法术技能攻击敌人", null);
        HeroStatus casterStatus = new HeroStatusV1(new ItemSuite(), new ArmorSuite(null, new Shirt()),
                new ConsumableSkillSuite(), new WeaponSuite(null, new Dagger()));
        casterStatus.getItemSuite().set(0,new SmallFireBall());
        casterStatus.setAttr(StatusType.STR,8);
        casterStatus.setAttr(StatusType.VIT,12);
        casterStatus.setAttr(StatusType.INT,16);
        casterStatus.setAttr(StatusType.LEVEL,31);
        caster.setStatus(casterStatus);
        initTypes[1] = caster;

        InitialHero beggar = new InitialHero("一无所有者","以最低劣的装备开始冒险，但容易升级",null);
        HeroStatus beggarStatus = new HeroStatusV1(new ItemSuite(),new ArmorSuite(null,null),
                new ConsumableSkillSuite(), new WeaponSuite(null,new WoodStick()));
        beggarStatus.setAttr(StatusType.STR,10);
        beggarStatus.setAttr(StatusType.VIT,10);
        beggarStatus.setAttr(StatusType.INT,10);
        beggarStatus.setAttr(StatusType.LEVEL,10);
        beggar.setStatus(beggarStatus);
        initTypes[2] = beggar;
    }

    public InitialHero[] getTypes() {
        return initTypes;
    }

    public void useType(InitialHero selected) {
        ManagerFactory mf = ManagerFactory.getInstance(Game.VERSION);
        SaveManager sm = mf.makeSaveManager();
        sm.saveHeroStatus(selected.getStatus());
        sm.saveMissionStatus(InitTourDataHelper.initMissionStatus());
    }

}
