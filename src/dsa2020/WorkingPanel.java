/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa2020;

import geom.Axis;
import geom.Graph;
import geom.Point2D;
import geom.SpaceMapping;
import sorting.Sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author LTSACH
 */
public class WorkingPanel extends JPanel
        implements MouseMotionListener, MouseListener, ItemListener, ActionListener, ComponentListener {

    Axis axis = new Axis();
    SpaceMapping spaceMapping = new SpaceMapping();
    int numOfGraphs = 10;
    Graph[] graphs = new Graph[numOfGraphs];

    public WorkingPanel() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addComponentListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
        String message =
                String.format(
                        "mouseDragged: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                        e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
        String message =
                String.format(
                        "mouseMoved: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                        e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getClickCount() == 2) && !e.isConsumed()) {
            Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
            String message =
                    String.format(
                            "mouseDoubleClicked: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                            e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
            MainFrame.infoPanel.println(message);
            e.consume();
        } else {
            Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
            String message =
                    String.format(
                            "mouseClicked: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                            e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
            MainFrame.infoPanel.println(message);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
        String message =
                String.format(
                        "mousePressed: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                        e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
        String message =
                String.format(
                        "mouseReleased: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                        e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
        String message =
                String.format(
                        "mouseEntered: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                        e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Point2D logicPoint = spaceMapping.device2Logic(e.getX(), e.getY());
        String message =
                String.format(
                        "mouseExit: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
                        e.getX(), e.getY(), logicPoint.getX(), logicPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
            MainFrame.infoPanel.println("Selected");
            MainFrame.btnSelect.setText("Selecting");
        } else {
            MainFrame.infoPanel.println("DeSelected");
            MainFrame.btnSelect.setText("Drawing");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MainFrame.btnCircle) {
            MainFrame.infoPanel.println("action: draw Circle");
        } else if (e.getSource() == MainFrame.btnRect) {
            MainFrame.infoPanel.println("action: draw Rect");
        } else if (e.getSource() == MainFrame.btnGraph) {
            //      quad = Graph.quadratic(10, -100, 250, 0, spaceMapping.wL(), spaceMapping.step());
            //      sin = Graph.sin(20, 2, 50, 0, spaceMapping.wL(), spaceMapping.step());
            //      sin.setMode(Graph.GraphMode.SCATTER);
            graphs = Sorting.graphIt(spaceMapping);
        } else if (e.getSource() == MainFrame.btnClear) {
            graphs = new Graph[numOfGraphs];
            spaceMapping.updateLogViewPort(0, 1, 0, 1);
            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        axis.draw(g, spaceMapping);

        if (graphs.length > 0) {
            for (Graph graph : graphs) {
                if (graph != null)
                    graph.draw(g, spaceMapping);
            }
            this.repaint();
        }
    }

    @Override
    public void componentResized(ComponentEvent ce) {
        Dimension size = this.getSize();
        int xGap = 50, yGap = 20;
        this.spaceMapping.updateDevViewPort(xGap, size.width - 2 * xGap, yGap, size.height - 2 * yGap);
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
}
