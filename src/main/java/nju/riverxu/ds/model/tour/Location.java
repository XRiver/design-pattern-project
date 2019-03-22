package nju.riverxu.ds.model.tour;

import java.io.Serializable;

/**
 * 将会同时被用于表示“绝对位置”与“相对位置/位移偏差”
 * 这样虽然不好，但我实在暂时不想增加class了。
 */
public class Location implements Serializable {
    private double x,y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Location l) {
        double xd = l.x - x, yd = l.y - y;
        return Math.sqrt(xd*xd+yd*yd);
    }
}
