package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.item.armor.BodyArmor;
import nju.riverxu.ds.model.item.armor.Helmet;
import nju.riverxu.ds.model.item.armor.body.NoBodyArmor;
import nju.riverxu.ds.model.item.armor.head.NoHelmet;

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
        this.helmetSlot = helmetSlot;
    }

    public BodyArmor getBodyArmor() {
        return bodyArmorSlot;
    }

    public void setBodyArmor(BodyArmor bodyArmorSlot) {
        this.bodyArmorSlot = bodyArmorSlot;
    }
}
