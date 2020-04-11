package geom;

import java.util.Comparator;

public class PointComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D p1, Point2D p2) {
        double distanceX = p1.getX() - p2.getX();
        double distanceY = p1.getY() - p2.getY();
        if (Math.abs(distanceX) < 1e-7)
            return 0;
        if (distanceX > 0)
            return 1;
        return -1;
    }
}
