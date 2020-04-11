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
public abstract class GeomObject {

    protected Color edgeColor;
    protected Color faceColor;
    protected int line_weight = 1;
    public GeomObject() {
        this.edgeColor = new Color(20, 200, 20);
        this.faceColor = Color.RED;
    }

    public void setFaceColor(Color faceColor) {
        this.faceColor = faceColor;
    }

    public abstract void draw(Graphics g, SpaceMapping mapper);
}
