package project.model;

import javax.vecmath.Point3d;

public class Face {

    private Point3d pointA;
    private Point3d pointB;
    private Point3d pointC;

    public Face(Point3d pointA, Point3d pointB, Point3d pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point3d getPointA() {
        return this.pointA;
    }

    public Point3d getPointB() {
        return this.pointB;
    }

    public Point3d getPointC() {
        return this.pointC;
    }
}
