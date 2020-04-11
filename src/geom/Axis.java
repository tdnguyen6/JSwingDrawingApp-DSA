/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import java.awt.*;

/**
 * @author TiDu
 */
public class Axis extends GeomObject {
    int stepX = 20;
    int stepY = 15;

    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graph xAxis =
                new Graph(new Point2D[]{new Point2D(0, 0), new Point2D(mapper.wL(), 0)}, Color.BLACK);
        Graph yAxis =
                new Graph(new Point2D[]{new Point2D(0, 0), new Point2D(0, mapper.hL())}, Color.BLACK);

        xAxis.draw(g, mapper);
        yAxis.draw(g, mapper);

        int xTagLength = 10;
        int yTagLength = 10;

        Point2D baseLogPosition = mapper.logic2Device(0, 0);

        g.drawString("0.00", (int) (baseLogPosition.getX() - 3 * xTagLength), (int) (baseLogPosition.getY() + 2 * yTagLength));

        // draw axis tag
        for (int i = 1; i <= stepX; i++) {
            double x = i * mapper.wL() / stepX;
            double length = xTagLength;
            if (i % 2 == 0) length /= 2;
            baseLogPosition = mapper.logic2Device(x, 0);
            g.drawLine((int) baseLogPosition.getX(), (int) baseLogPosition.getY(), (int) baseLogPosition.getX(), (int) (baseLogPosition.getY() + length));
            g.drawString(
                    String.format("%.2f", x),
                    (int) (baseLogPosition.getX() - xTagLength),
                    (int) (baseLogPosition.getY() + 3 * yTagLength));
        }
        for (int i = 1; i <= stepY; i++) {
            double y = i * mapper.hL() / stepY;
            double length = yTagLength;
            if (i % 2 == 0) length /= 2;
            baseLogPosition = mapper.logic2Device(0, y);
            g.drawLine((int) baseLogPosition.getX(), (int) baseLogPosition.getY(), (int) (baseLogPosition.getX() - length), (int) baseLogPosition.getY());
            g.drawString(
                    String.format("%.2f", y),
                    (int) (baseLogPosition.getX() - 4 * xTagLength),
                    (int) (baseLogPosition.getY() + yTagLength / 2));
        }
    }
}
