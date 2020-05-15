package project.model.configuration;

import javax.vecmath.Point3d;

public class CuboidGeneratorConfiguration {

    private Point3d mainPoint;
    private Point3d pointA;
    private Point3d pointB;
    private Point3d pointC;

    public CuboidGeneratorConfiguration(Point3d mainPoint, Point3d pointA, Point3d pointB, Point3d pointC) {
        this.mainPoint = mainPoint;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point3d getMainPoint() {
        return mainPoint;
    }

    public void setMainPoint(Point3d mainPoint) {
        this.mainPoint = mainPoint;
    }

    public Point3d getPointA() {
        return pointA;
    }

    public void setPointA(Point3d pointA) {
        this.pointA = pointA;
    }

    public Point3d getPointB() {
        return pointB;
    }

    public void setPointB(Point3d pointB) {
        this.pointB = pointB;
    }

    public Point3d getPointC() {
        return pointC;
    }

    public void setPointC(Point3d pointC) {
        this.pointC = pointC;
    }
}
