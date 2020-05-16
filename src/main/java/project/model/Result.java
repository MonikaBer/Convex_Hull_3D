package project.model;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Result {

    private ArrayList<Point3d> result;
    private double runtime;

    public Result(ArrayList<Point3d> result, double runtime) {
        this.result = result;
        this.runtime = runtime;
    }

    public ArrayList<Point3d> getResult() {
        return result;
    }

    public double getRuntime() {
        return runtime;
    }
}
