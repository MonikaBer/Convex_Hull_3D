package project.view.visualizer.panels;

import javax.vecmath.Point3d;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Point {

    private double x, y;
    private double diameter = 0.1;
    private Ellipse2D graphicRepresentation;
    private Color color;

    public Point(Point3d point, Color color) {
        this.x = Math.cos(30) * point.x - Math.cos(30) * point.y;
        this.y = Math.sin(30) * point.x + Math.sin(30) * point.y + point.z;
        this.color = color;
    }

    public void generateGraphicRepresentation() {
        this.graphicRepresentation = new Ellipse2D.Double(this.x, this.y, this.diameter, this.diameter);
    }

    public Ellipse2D getGraphicRepresentation() {
        return graphicRepresentation;
    }

    public Color getColor() {
        return color;
    }
}
