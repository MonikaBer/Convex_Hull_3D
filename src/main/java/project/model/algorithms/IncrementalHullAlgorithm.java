package project.model.algorithms;

import project.model.Face;
import project.model.Result;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class IncrementalHullAlgorithm extends ConvexHullAlgorithm {

    public IncrementalHullAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHull = new ArrayList<>();
        //set runtime
        double runtime = 0.0;
        return new Result(convexHull, runtime);
    }
}
