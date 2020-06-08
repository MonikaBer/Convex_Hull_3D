package project.model.configuration;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class CuboidGeneratorConfiguration {

    private Point3d mainPoint;
    private Vector3d vectorA;
    private Vector3d vectorB;
    private Vector3d vectorC;

    public CuboidGeneratorConfiguration(Point3d mainPoint, Vector3d vectorA, Vector3d vectorB, Vector3d vectorC) {
        this.mainPoint = mainPoint;
        this.vectorA = vectorA;
        this.vectorB = vectorB;
        this.vectorC = vectorC;
    }

    public Point3d getMainPoint() {
        return mainPoint;
    }

    public void setMainPoint(Point3d mainPoint) {
        this.mainPoint = mainPoint;
    }

    public Vector3d getVectorA() {
        return vectorA;
    }

    public void setVectorA(Vector3d vectorA) {
        this.vectorA = vectorA;
    }

    public Vector3d getVectorB() {
        return vectorB;
    }

    public void setVectorB(Vector3d vectorB) {
        this.vectorB = vectorB;
    }

    public Vector3d getVectorC() {
        return vectorC;
    }

    public void setVectorC(Vector3d vectorC) {
        this.vectorC = vectorC;
    }
}
