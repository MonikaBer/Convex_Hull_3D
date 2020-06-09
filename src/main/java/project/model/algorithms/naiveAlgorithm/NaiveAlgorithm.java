package project.model.algorithms.naiveAlgorithm;

import project.model.Face;
import project.model.Result;
import project.model.algorithms.ConvexHullAlgorithm;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;

public class NaiveAlgorithm extends ConvexHullAlgorithm {

    public NaiveAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHull = new ArrayList<>();
        //start runtime
        double runtime = 0.0;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i+1; j < points.size(); j++) {
                for (int k = j+1; k < points.size(); k++) {
                    if (isSurfaceExtreme(points, i, j, k)) {
                        convexHull.add(new Face(points.get(i), points.get(j), points.get(k)));
                    }
                }
            }
        }
        //measure runtime
        return new Result(convexHull, runtime);
    }

    private boolean isSurfaceExtreme(ArrayList<Point3d> points, int nr1, int nr2, int nr3) {
        //check if surface defined by (point1, point2, point3) is extreme
        //point nr1 chosen
        Vector3d normal = new Vector3d();
        normal.cross(
                new Vector3d(
                        points.get(nr2).x - points.get(nr1).x,
                        points.get(nr2).y - points.get(nr1).y,
                        points.get(nr2).z - points.get(nr1).z),
                new Vector3d(
                        points.get(nr3).x - points.get(nr1).x,
                        points.get(nr3).y - points.get(nr1).y,
                        points.get(nr3).z - points.get(nr1).z));


        double firstScalar = normal.dot(new Vector3d(
                points.get(0).x - points.get(nr1).x,
                points.get(0).y - points.get(nr1).y,
                points.get(0).z - points.get(nr1).z));

        double scalar;
        for (int i = 1; i < points.size(); i++) {
            scalar = normal.dot(new Vector3d(
                points.get(i).x - points.get(nr1).x,
                points.get(i).y - points.get(nr1).y,
                points.get(i).z - points.get(nr1).z));

            if (Math.signum(firstScalar) != Math.signum(scalar))
                return false;
        }
        return true;
    }
}
