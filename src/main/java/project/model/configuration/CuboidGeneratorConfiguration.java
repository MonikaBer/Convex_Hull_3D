package project.model.configuration;

import javax.vecmath.Point3d;
import javax.vecmath.Tuple3d;

public class CuboidGeneratorConfiguration {

    private Point3d mainPoint;
    private Tuple3d vectorA;
    private Tuple3d vectorB;
    private Tuple3d vectorC;

    public CuboidGeneratorConfiguration(Point3d mainPoint, Tuple3d vectorA, Tuple3d vectorB, Tuple3d vectorC) {
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

    public Tuple3d getVectorA() {
        return vectorA;
    }

    public void setVectorA(Tuple3d vectorA) {
        this.vectorA = vectorA;
    }

    public Tuple3d getVectorB() {
        return vectorB;
    }

    public void setVectorB(Tuple3d vectorB) {
        this.vectorB = vectorB;
    }

    public Tuple3d getVectorC() {
        return vectorC;
    }

    public void setVectorC(Tuple3d vectorC) {
        this.vectorC = vectorC;
    }
}
