package project.model.algorithms;

import project.model.Face;
import project.model.Result;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class GiftWrappingAlgorithm extends ConvexHullAlgorithm {

    public GiftWrappingAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHullFaces = new ArrayList<>();
        ArrayList<Point3d> convexHullPoints = new ArrayList<>();
        //start runtime
        Double runtime = 0.0;

        //find a first face of convex hull
        Point3d point1;  //minimum point
        Point3d point2;  //next point after point1 (in the lexicographical order)
        Point3d point3;  //next point after point2 (in the lexicographical order)
        point1 = points.get(0);
        if (!isLexicographicalOrder(point1, points.get(1))) {
            point2 = point1;
            point1 = points.get(1);
        } else {
            point2 = points.get(1);
        }
        if (!isLexicographicalOrder(point2, points.get(2))) {
            point3 = point2;
            if (!isLexicographicalOrder(point1, points.get(2))) {
                point2 = point1;
                point1 = points.get(2);
            } else {
                point2 = points.get(2);
            }
        } else {
            point3 = points.get(2);
        }

        for (int i = 3; i < points.size(); i++) {
            if (isLexicographicalOrder(point3, points.get(i))) {
                continue;
            }
            if (isLexicographicalOrder(point2, points.get(i))) {
                point3 = points.get(i);
                continue;
            }
            point3 = point2;
            if (isLexicographicalOrder(point1, points.get(i))) {
                point2 = points.get(i);
                continue;
            }
            point2 = point1;
            point1 = points.get(i);
        }
        //point1, point2, point3 are the minimum points in the lexicographical order
        convexHullFaces.add(new Face(point1, point2, point3));   //certainly, this face belongs to the convex hull
        convexHullPoints.add(point1);
        convexHullPoints.add(point2);
        convexHullPoints.add(point3);

        //build the convex hull
//        while () {
//
//        }

        //measure runtime
        return new Result(convexHullFaces, runtime);
    }

    private static boolean isLexicographicalOrder(Point3d point1, Point3d point2) {
        if (point1.x < point2.x || (point1.x == point2.x && point1.y < point2.y) ||
                (point1.x == point2.x && point1.y == point2.y && point1.z <= point2.z)) {

            return true;
        }
        return false;
    }
}
