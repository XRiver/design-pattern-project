package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.item.ArmorSuite;
import nju.riverxu.ds.model.item.ConsumableSuite;
import nju.riverxu.ds.model.item.ItemSuite;
import nju.riverxu.ds.model.item.WeaponSuite;
import nju.riverxu.ds.model.spirit.Hero;
import nju.riverxu.ds.model.spirit.HeroStatus;
import nju.riverxu.ds.model.spirit.HeroStatusV1;
import nju.riverxu.ds.model.spirit.StatusType;
import nju.riverxu.ds.util.ManagerFactory;
import nju.riverxu.ds.util.ManagerFactoryVersion;

import java.io.*;


public class CharacterInitializeManagerDebug implements CharacterInitializeManager {

    private static CharacterInitializeManager instance = new CharacterInitializeManagerDebug();
    public static CharacterInitializeManager getInstance() {
        return instance;
    }

    public InitialHero[] getTypes() {
        //TODO
        InitialHero beggar = new InitialHero("一无所有者",
                "以最低劣的装备开始冒险",
                null);
        HeroStatus beggarStatus = new HeroStatusV1(new ItemSuite(),new ArmorSuite(null,null), new ConsumableSuite(), new WeaponSuite(null,null));
        beggarStatus.setAttr(StatusType.STR,10);
        beggarStatus.setAttr(StatusType.VIT,10);
        beggarStatus.setAttr(StatusType.INT,10);

        beggar.setStatus(beggarStatus);

        return new InitialHero[]{beggar};
    }

    public void useType(InitialHero selected) {
        ManagerFactory.getInstance(ManagerFactoryVersion.DEBUG).makeSaveManager().saveHeroStatus(selected.getStatus());
    }

    public static void main(String[] args) {
        CharacterInitializeManager m = CharacterInitializeManagerDebug.getInstance();
        System.out.println(m.getTypes()[0].getStatus().getWeaponSuite().getLeftHand().getClass());

        try {
            FileOutputStream fos = new FileOutputStream("status.save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m.getTypes());
            oos.close();
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("status.save");
            ObjectInputStream ios = new ObjectInputStream(fis);
            InitialHero[] read = (InitialHero[])ios.readObject();
            ios.close();
            fis.close();

            System.out.println(read[0].getStatus().getWeaponSuite().getLeftHand().getClass());
            System.out.println(read[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
