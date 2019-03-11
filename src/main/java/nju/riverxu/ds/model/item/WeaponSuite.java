package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.item.weapon.Fist;

public class WeaponSuite {
    private Weapon leftHand = null;
    private Weapon rightHand = null;

    public WeaponSuite(Weapon leftHand, Weapon rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;

        if (leftHand == null) {
            this.leftHand = new Fist();
        }
        if (rightHand == null) {
            this.rightHand = new Fist();
        }
    }

    public Weapon getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Weapon leftHand) {
        this.leftHand = leftHand;
    }

    public Weapon getRightHand() {
        return rightHand;
    }

    public void setRightHand(Weapon rightHand) {
        this.rightHand = rightHand;
    }
}
