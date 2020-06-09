package project.model;

import javax.vecmath.Point3d;

public class Face {

    protected Point3d pointA;
    protected Point3d pointB;
    protected Point3d pointC;

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

    public void setPointA(Point3d pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point3d pointB) {
        this.pointB = pointB;
    }

    public void setPointC(Point3d pointC) {
        this.pointC = pointC;
    }
}
