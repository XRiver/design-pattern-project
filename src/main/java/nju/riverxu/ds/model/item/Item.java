package nju.riverxu.ds.model.item;

import java.io.Serializable;

interface Item extends Serializable {
    void use();
    String getName();
    double getWeight();
}
