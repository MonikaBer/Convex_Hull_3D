package project.model.algorithms.naiveAlgorithm;

import project.model.Face;
import project.model.Result;
import project.model.algorithms.ConvexHullAlgorithm;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NaiveAlgorithm extends ConvexHullAlgorithm {
    private static final double EPSILON = 1e-7;

    public NaiveAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        // not all points collinear
        ArrayList<Face> convexHull = new ArrayList<>();
        //start runtime
        double runtime = 0.0;

        Set<Point3d> p = new HashSet<>();

        for (int i = 0; i < points.size(); i++) {
            for (int j = i+1; j < points.size(); j++) {
                for (int k = j+1; k < points.size(); k++) {
                    if (isSurfaceExtreme(points, i, j, k)) {
                        p.add(points.get(i));
                        p.add(points.get(j));
                        p.add(points.get(k));


                        convexHull.add(new Face(points.get(i), points.get(j), points.get(k)));
                    }
                }
            }
        }

        System.out.println("Naive Algorithm finished");

        //measure runtime
        return new Result(convexHull, runtime, points);
    }

    private boolean isSurfaceExtreme(ArrayList<Point3d> points, int nr1, int nr2, int nr3) {
        //check if surface defined by (point1, point2, point3) is extreme
        //point nr1 chosen
        Point3d pivot = points.get(nr1);

        Vector3d normal = new Vector3d();
        normal.cross(
                subtract(points.get(nr2), pivot),
                subtract(points.get(nr3), pivot));
        if (normal.lengthSquared() < EPSILON) {
            return false;
        }

        Set<Double> signs = new HashSet<>();
        for (int i = 0; i < points.size(); i++) {
            if (i == nr1 || i == nr2 || i == nr3) {
                continue;
            }
            double sign = Math.signum(normal.dot(subtract(points.get(i), pivot)));
            if (sign != 0.) {
                signs.add(sign);
            }
        }
        return signs.size() == 1;
    }

    private Vector3d subtract(Point3d a, Point3d b) {
        return new Vector3d(a.x - b.x, a.y - b.y, a.z - b.z);
    }
}
