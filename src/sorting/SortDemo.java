package sorting;

import geom.Point2D;
import geom.PointComparator;
import sorting.ISort.SortDirection;

import java.util.Comparator;

public class SortDemo {
    /**
     * @param demoSize
     * @param sortAlg
     */
    public static void demoValue(int demoSize, ISort sortAlg) {
        Point2D[] points = Point2D.generate(demoSize, -20, 20);
        System.out.println("Demo for " + sortAlg);
        System.out.println(new String(new char[80]).replace('\0', '-'));
        System.out.println("Unsorted list points: ");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
        sortAlg.sort(points, new PointComparator());
        System.out.println("");
        System.out.println(
                "Sorted list of points (sorted by x-coordinates, ASCENDING)");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
    }

    /**
     * @param demoSize
     * @param sortAlg
     * @param sortDirection
     */
    public static void demoValue(int demoSize, ISort sortAlg, SortDirection sortDirection) {
        Point2D[] points = Point2D.generate(demoSize, -20, 20);
        System.out.println("Demo for " + sortAlg);
        System.out.println(new String(new char[80]).replace('\0', '-'));
        System.out.println("Unsorted list points: ");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
        sortAlg.sort(points, new PointComparator(), sortDirection);
        System.out.println("");
        System.out.println(
                "Sorted list of points (sorted by x-coordinates, " + sortDirection + ")");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
    }

    /**
     * @param demoSize
     * @param sortAlg
     */
    public static void demoTime(int demoSize, int nExec, ISort sortAlg) {
        Point2D[] results = SortingEval.timeit(sortAlg, demoSize, nExec);
        System.out.println(sortAlg + " : Time measurement");
        System.out.println(String.format("%-8sTime (msec)", "Size"));
        System.out.println(new String(new char[60]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%-8d%f", (int) results[i].getX(), results[i].getY());
            System.out.println(line);
        }
    }

    /**
     * @param demoSize
     * @param sortAlg
     * @param comparator
     */
    public static void demoValue(int demoSize, ISort sortAlg, Comparator<Point2D> comparator) {
        Point2D[] points = Point2D.generate(demoSize, -20, 20);
        System.out.println("Demo for " + sortAlg);
        System.out.println(new String(new char[80]).replace('\0', '-'));
        System.out.println("Unsorted list points: ");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
        sortAlg.sort(points, comparator);
        System.out.println("");
        System.out.println(
                "Sorted list of points (sorted by x-coordinates, ASCENDING)");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
    }

    /**
     * @param demoSize
     * @param sortAlg
     * @param sortDirection
     */
    public static void demoValue(int demoSize, ISort sortAlg, SortDirection sortDirection, Comparator<Point2D> comparator) {
        Point2D[] points = Point2D.generate(demoSize, -20, 20);
        System.out.println("Demo for " + sortAlg);
        System.out.println(new String(new char[80]).replace('\0', '-'));
        System.out.println("Unsorted list points: ");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
        sortAlg.sort(points, comparator, sortDirection);
        System.out.println("");
        System.out.println(
                "Sorted list of points (sorted by x-coordinates, " + sortDirection + ")");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%3d | %s", i, points[i]);
            System.out.println(line);
        }
    }

    /**
     * @param demoSize
     * @param sortAlg
     */
    public static void demoTime(int demoSize, int nExec, ISort sortAlg, Comparator<Point2D> comparator) {
        Point2D[] results = SortingEval.timeit(sortAlg, demoSize, nExec, comparator);
        System.out.println(sortAlg + " : Time measurement");
        System.out.println(String.format("%-8sTime (msec)", "Size"));
        System.out.println(new String(new char[60]).replace('\0', '-'));
        for (int i = 0; i < demoSize; i++) {
            String line = String.format("%-8d%f", (int) results[i].getX(), results[i].getY());
            System.out.println(line);
        }
    }
}
