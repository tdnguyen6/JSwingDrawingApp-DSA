package geom;

import java.util.Comparator;

public class M2PointComparator implements Comparator<Point2D> {
    Point2D COM = new Point2D();

    public M2PointComparator(Point2D[] points) {
        double sumX = 0;
        double sumY = 0;
        for (Point2D p : points) {
            sumX += p.getX();
            sumY += p.getY();
        }
        COM.setX(sumX / points.length);
        COM.setY(sumY / points.length);
    }

    @Override
    public int compare(Point2D p1, Point2D p2) {
        double OtoP1 = p1.distanceTo(COM);
        double OtoP2 = p2.distanceTo(COM);
        double difference = OtoP1 - OtoP2;
        if (Math.abs(difference) < 10e-7)
            return 0;
        if (difference > 0)
            return 1;
        return -1;
    }
}
