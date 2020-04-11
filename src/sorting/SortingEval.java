package sorting;

import geom.Point2D;
import geom.PointComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingEval {
    public static Point2D[] timeit(ISort algorithm, int nElementMax, int nExec) {
        Point2D[] algPerformance = new Point2D[nElementMax];
        algPerformance[0] = new Point2D(0, 0);
        for (int i = 1; i < nElementMax; i++) {
            double timeElapsed = 0;
            for (int c = 0; c < nExec; c++) {
                Point2D[] points = Point2D.generate(i, -20, 20);
                long startTime = System.nanoTime();
                algorithm.sort(points, new PointComparator());
                long endTime = System.nanoTime();
                timeElapsed += (double) (endTime - startTime) / (nExec * 1000000);
            }
            algPerformance[i] = new Point2D(i, timeElapsed);
        }
        return algPerformance;
    }

    public static Point2D[] timeit(ISort algorithm, int nElementMax, int nExec, Comparator<Point2D> comparator) {
        Point2D[] algPerformance = new Point2D[nElementMax];
        algPerformance[0] = new Point2D(0, 0);
        for (int i = 1; i < nElementMax; i++) {
            double timeElapsed = 0;
            for (int c = 0; c < nExec; c++) {
                Point2D[] points = Point2D.generate(i, -20, 20);
                long startTime = System.nanoTime();
                algorithm.sort(points, comparator);
                long endTime = System.nanoTime();
                timeElapsed += (double) (endTime - startTime) / (nExec * 1000000);
            }
            algPerformance[i] = new Point2D(i, timeElapsed);
        }
        return algPerformance;
    }

    public static Point2D[] timeit(ISort algorithm, int nElementMax, int nExec, Comparator<Point2D> comparator, CASE aCase) {
        Point2D[] algPerformance = new Point2D[nElementMax];
        algPerformance[0] = new Point2D(0, 0);
        for (int i = 1; i < nElementMax; i++) {
            double timeElapsed = 0;
            for (int c = 0; c < nExec; c++) {
                Point2D[] points = Point2D.generate(i, -20, 20);
                if (aCase.equals(CASE.BEST)) {
                    Arrays.sort(points, comparator);
                }
                else if (aCase.equals(CASE.WORST)) {
                    Arrays.sort(points, Collections.reverseOrder(comparator));
                }
                long startTime = System.nanoTime();
                algorithm.sort(points, comparator);
                long endTime = System.nanoTime();
                timeElapsed += (double) (endTime - startTime) / (nExec * 1000000);
            }
            algPerformance[i] = new Point2D(i, timeElapsed);
        }
        return algPerformance;
    }

    public static enum CASE {
        BEST,
        WORST
    }
}