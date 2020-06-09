package project.model.algorithms;

import project.model.Face;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;

public class AlgorithmsHelper {

    public static boolean isLexicographicalOrder(Point3d point1, Point3d point2) {
        if (point1.x < point2.x || (point1.x == point2.x && point1.y < point2.y) ||
                (point1.x == point2.x && point1.y == point2.y && point1.z <= point2.z)) {
            return true;
        }
        return false;
    }

    public static Face findFirstFace(ArrayList<Point3d> points) {
        //point1, point2, point3 will be the minimum points in the lexicographical order
        Point3d point1;  //minimum point
        Point3d point2;  //next point after point1 (in the lexicographical order)
        Point3d point3;  //next point after point2 (in the lexicographical order)

        //determine the lowest three points from points (according to lexicographical order)
        point1 = points.get(0);
        if (!AlgorithmsHelper.isLexicographicalOrder(point1, points.get(1))) {
            point2 = point1;
            point1 = points.get(1);
        } else {
            point2 = points.get(1);
        }
        if (!AlgorithmsHelper.isLexicographicalOrder(point2, points.get(2))) {
            point3 = point2;
            if (!AlgorithmsHelper.isLexicographicalOrder(point1, points.get(2))) {
                point2 = point1;
                point1 = points.get(2);
            } else {
                point2 = points.get(2);
            }
        } else {
            point3 = points.get(2);
        }

        for (int i = 3; i < points.size(); i++) {
            if (!AlgorithmsHelper.isLexicographicalOrder(point1, points.get(i))) {
                point1 = points.get(i);
                point2 = point1;
                point3 = point2;
            } else {
                if (!AlgorithmsHelper.isLexicographicalOrder(point2, points.get(i))) {
                    point2 = points.get(i);
                    point3 = point2;
                } else {
                    if (!AlgorithmsHelper.isLexicographicalOrder(point3, points.get(i))) {
                        point3 = points.get(i);
                    }
                }
            }
        }
        return new Face(point1, point2, point3);
    }

    public static double countAngleBetweenFaces(Face face1, Face face2) {  //previous face and face
        Vector3d face1normal = new Vector3d();
        Vector3d face2normal = new Vector3d();

        face1normal.cross(new Vector3d(
                        face1.getPointC().x - face1.getPointA().x,
                        face1.getPointC().y - face1.getPointA().y,
                        face1.getPointC().z - face1.getPointA().z),
                new Vector3d(
                        face1.getPointB().x - face1.getPointA().x,
                        face1.getPointB().y - face1.getPointA().y,
                        face1.getPointB().z - face1.getPointA().z));

        face2normal.cross(new Vector3d(
                        face2.getPointB().x - face2.getPointA().x,
                        face2.getPointB().y - face2.getPointA().y,
                        face2.getPointB().z - face2.getPointA().z),
                new Vector3d(
                        face2.getPointC().x - face2.getPointA().x,
                        face2.getPointC().y - face2.getPointA().y,
                        face2.getPointC().z - face2.getPointA().z));

        //count angle between normals of face1 and face2
        return Math.acos(face1normal.dot(face2normal) / (face1normal.length() * face2normal.length()));
    }
}
