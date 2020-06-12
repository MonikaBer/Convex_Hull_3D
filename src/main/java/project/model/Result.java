package project.model;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Result {

    private ArrayList<Face> faces;
    private double runtime;
    private ArrayList<Point3d> inputPoints;

    public Result(ArrayList<Face> faces, double runtime, ArrayList<Point3d> inputPoints) {
        this.faces = faces;
        this.runtime = runtime;
        this.inputPoints = inputPoints;
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    public double getRuntime() {
        return runtime;
    }

    public ArrayList<Point3d> getInputPoints() {
        return inputPoints;
    }
}
