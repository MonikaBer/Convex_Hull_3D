package project.model.algorithms;

import project.model.Result;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class IncrementalHullAlgorithm extends ConvexHullAlgorithm {

    public IncrementalHullAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Point3d> convexHull = new ArrayList<>();
        //set runtime
        Double runtime = 0.0;
        return new Result(convexHull, runtime);
    }
}
