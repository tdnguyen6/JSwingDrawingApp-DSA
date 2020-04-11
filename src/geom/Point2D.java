package geom;

import java.awt.*;

public class Point2D extends GeomObject {

    public static int POINT_HALF_SIZE = 2;
    private double x;
    private double y;
    // Add setters and getters here: Reuse code from LAB1

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D oldPoint) {
        this.x = oldPoint.x;
        this.y = oldPoint.y;
    }

    public static Point2D[] generate(int num, double min, double max) {
        // Reuse code from LAB1
        Point2D[] points = new Point2D[num];
        for (int i = 0; i < num; i++) {
            points[i] = new Point2D(randomDouble(min, max), randomDouble(min, max));
        }
        return points;
    }

    private static double randomDouble(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (Math.random() * (max - min)) + min;
    }

    public static Point2D[] linear(int N, double a, double b, double xMin, double xMax) {
        Point2D[] list = new Point2D[N];
        double step = (xMax - xMin) / (N - 1); // xMax inclusive
        double x = xMin;
        for (int idx = 0; idx < N; idx++) {
            /*answer here*/
            double y = a * x + b;
            Point2D point2D = new Point2D(x, y);
            list[idx] = point2D;
            x += step;
        }
        return list;
    }

    public static double distanceAB(Point2D a, Point2D b) {
        // Reuse code from LAB1
        double xDiff = Math.pow((a.x - b.x), 2);
        double yDiff = Math.pow((a.y - b.y), 2);
        double distance = Math.sqrt(xDiff + yDiff);
        return distance;
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

    public Point2D clone() {
        return new Point2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return String.format("P(%6.2f, %6.2f)", this.x, this.y);
    }

    public double distanceTo(Point2D point) {
        // Reuse code from LAB1
        return distanceAB(this, point);
    }

    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graphics2D g2 = (Graphics2D) g;
        Point2D point = mapper.logic2Device(this.getX(), this.getY());

        int x = (int) point.getX() - POINT_HALF_SIZE;
        int y = (int) point.getY() - POINT_HALF_SIZE;

        g2.setColor(this.faceColor);
        g2.fillOval(
                /*anwser here*/ x, y,
                POINT_HALF_SIZE * 2,
                POINT_HALF_SIZE * 2);
    }
}
