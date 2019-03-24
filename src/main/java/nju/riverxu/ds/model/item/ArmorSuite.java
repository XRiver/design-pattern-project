package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.item.armor.BodyArmor;
import nju.riverxu.ds.model.item.armor.Helmet;
import nju.riverxu.ds.model.item.armor.body.NoBodyArmor;
import nju.riverxu.ds.model.item.armor.head.NoHelmet;
import nju.riverxu.ds.model.spirit.AttackInfo;
import nju.riverxu.ds.model.spirit.Spirit;

import java.io.Serializable;

public class ArmorSuite implements Serializable {
    private Helmet helmetSlot = null;
    private BodyArmor bodyArmorSlot = null;

    public ArmorSuite(Helmet helmetSlot, BodyArmor bodyArmorSlot) {
        this.helmetSlot = helmetSlot;
        this.bodyArmorSlot = bodyArmorSlot;

        if (helmetSlot == null) {
            this.helmetSlot = new NoHelmet();
        }
        if (bodyArmorSlot == null) {
            this.bodyArmorSlot = new NoBodyArmor();
        }
    }

    public Helmet getHelmet() {
        return helmetSlot;
    }

    public void setHelmet(Helmet helmetSlot) {
        if(helmetSlot != null) {
            this.helmetSlot = helmetSlot;
        } else {
            this.helmetSlot = new NoHelmet();
        }

    }

    public BodyArmor getBodyArmor() {
        return bodyArmorSlot;
    }

    public void setBodyArmor(BodyArmor bodyArmorSlot) {
        if(bodyArmorSlot!= null) {
            this.bodyArmorSlot = bodyArmorSlot;
        } else {
            this.bodyArmorSlot = new NoBodyArmor();
        }
    }

    public Armor get(int slot) {
        if(slot==0) {
            return helmetSlot;
        } else if (slot==1) {
            return bodyArmorSlot;
        }
        return null;
    }

    public void set(int slot, Armor item) {
        if(slot==0) {
            setHelmet((Helmet) item);
        } else if (slot==1) {
            setBodyArmor((BodyArmor) item);
        }
    }

    public Armor[] getArray() {
        return new Armor[]{helmetSlot,bodyArmorSlot};
    }

    @Override
    public String toString() {
        return "护甲套装{" +
                "头部=" + helmetSlot.getName() +
                ", 身体=" + bodyArmorSlot.getName() +
                '}';
    }

    /**
     * Demo版不根据具体Armor与角色属性计算真正伤害，而是固定减伤20% 。即使“没有护甲”也是这样。
     * @param info
     * @param target
     * @return
     */
    public double getRealDamage(AttackInfo info, Spirit target) {

        return info.getRawDamage()*0.8;
    }

}
