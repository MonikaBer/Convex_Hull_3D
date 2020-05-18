package project.model.algorithms;

import project.model.Face;
import project.model.Result;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class NaiveAlgorithm extends ConvexHullAlgorithm {

    public NaiveAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHull = new ArrayList<>();
        //start runtime
        Double runtime = 0.0;

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                for (int k = 0; k < points.size(); k++) {
                    if (isSurfaceExtreme(points.get(i), points.get(j), points.get(k))) {
                        convexHull.add(new Face(points.get(i), points.get(j), points.get(k)));
                    }
                }
            }
        }

        //measure runtime
        return new Result(convexHull, runtime);
    }

    private boolean isSurfaceExtreme(Point3d point1, Point3d point2, Point3d point3) {
        //check if surface defined by (point1, point2, point3) is extreme
        return false;
    }
}
