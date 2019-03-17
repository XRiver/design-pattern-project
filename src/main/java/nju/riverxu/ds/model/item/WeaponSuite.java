package nju.riverxu.ds.model.item;

import nju.riverxu.ds.model.item.weapon.Fist;

import java.io.Serializable;

public class WeaponSuite implements Serializable {
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
        if (leftHand != null) {
            this.leftHand = leftHand;
        } else {
            this.leftHand = new Fist();
        }

    }

    public Weapon getRightHand() {
        return rightHand;
    }

    public void setRightHand(Weapon rightHand) {
        if(rightHand!= null) {
            this.rightHand = rightHand;
        } else {
            this.rightHand = new Fist();
        }
    }

    public Weapon[] getArray() {
        return new Weapon[]{leftHand,rightHand};
    }

    public Weapon get(int slot) {
        if(slot==0) {
            return leftHand;
        } else if(slot==1) {
            return rightHand;
        }
        return null;
    }

    public void set(int slot, Weapon w) {
        if (slot==0) {
            setLeftHand(w);
        } else if (slot==1) {
            setRightHand(w);
        }
    }

    @Override
    public String toString() {
        return "武器套装{" +
                "左手=" + leftHand.getName() +
                ", 右手=" + rightHand.getName() +
                '}';
    }
}
