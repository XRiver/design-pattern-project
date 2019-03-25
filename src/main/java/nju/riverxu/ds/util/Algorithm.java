package nju.riverxu.ds.util;

import nju.riverxu.ds.model.spirit.Direction;
import nju.riverxu.ds.model.tour.Location;

public class Algorithm {
    /* Hope this works:
    https://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment#

     * function sqr(x) { return x * x }
     * function dist2(v, w) { return sqr(v.x - w.x) + sqr(v.y - w.y) }
     * function distToSegmentSquared(p, v, w) {
     *   var l2 = dist2(v, w);
     *   if (l2 == 0) return dist2(p, v);
     *   var t = ((p.x - v.x) * (w.x - v.x) + (p.y - v.y) * (w.y - v.y)) / l2;
     *   t = Math.max(0, Math.min(1, t));
     *   return dist2(p, { x: v.x + t * (w.x - v.x),
     *                     y: v.y + t * (w.y - v.y) });
     * }
     * function distToSegment(p, v, w) { return Math.sqrt(distToSegmentSquared(p, v, w)); }
     */
    public static double distToSegment(Location pt, Location loc1, Location loc2) {
        return Math.sqrt(distToSegmentSquared(pt, loc1, loc2));
    }

    private static double sqr(double x) {
        return x * x;
    }

    private static double distSqr(Location loc1, Location loc2) {
        return sqr(loc1.getX() - loc2.getX()) + sqr(loc1.getY() - loc2.getY());
    }

    private static double distToSegmentSquared(Location pt, Location loc1, Location loc2) {
        double l2 = distSqr(loc1, loc2);
        if (l2 == 0.0) return loc1.distance(pt);

        double t = ((pt.getX() - loc1.getX()) * (loc2.getX() - loc1.getX()) + (pt.getY() - loc1.getY()) * (loc2.getY() - loc1.getY())) / l2;
        t = Math.max(0.0, Math.min(1.0, t));
        return distSqr(pt, new Location(loc1.getX() + t * (loc2.getX() - loc1.getX()), loc1.getY() + t * (loc2.getY() - loc1.getY())));
    }

    public static Location getMigratedLocation(Location base, Direction direction, double diff) {
        switch (direction) {
            case EAST:
                return new Location(base.getX() + diff, base.getY());
            case WEST:
                return new Location(base.getX() - diff, base.getY());
            case NORTH:
                return new Location(base.getX(), base.getY() - diff);
            case SOUTH:
                return new Location(base.getX(), base.getY() + diff);
            default:
                return null;
        }
    }

    public static Direction getRelativeDirection(Location base, Location target) {
        Direction ret = Direction.NORTH;
        double xRelative = target.getX()-base.getX();
        double yRelative = target.getY() - base.getY();

        if(xRelative > 0) { // EAST/N/S
            ret = Direction.EAST;
            if(yRelative > xRelative) {
                ret = Direction.SOUTH;
            } else if (yRelative < -xRelative) {
                ret = Direction.NORTH;
            }
        } else { //WEST/N/S
            ret = Direction.WEST;
            if(yRelative < xRelative) {
                ret = Direction.NORTH;
            } else if(yRelative > -xRelative) {
                ret = Direction.SOUTH;
            }
        }
        return ret;
    }
}
