package geom;

import java.util.Comparator;

public class O2PointComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D p1, Point2D p2) {
        double OtoP1 = p1.distanceTo(new Point2D(0, 0));
        double OtoP2 = p2.distanceTo(new Point2D(0, 0));
        double difference = OtoP1 - OtoP2;
        if (Math.abs(difference) < 10e-7)
            return 0;
        if (difference > 0)
            return 1;
        return -1;
    }
}
