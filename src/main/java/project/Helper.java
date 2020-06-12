package project;

import project.model.Face;

import javax.vecmath.Point3d;

public class Helper {

    public static boolean pointsEqual(Point3d point1, Point3d point2) {
        if (point1.x == point2.x && point1.y == point2.y && point1.z == point2.z)
            return true;
        return false;
    }

    public static boolean facesEqual(Face face1, Face face2) {
        if (    (pointsEqual(face1.getPointA(), face2.getPointA())  ||
                pointsEqual(face1.getPointA(), face2.getPointB())   ||
                pointsEqual(face1.getPointA(), face2.getPointC()))
                &&
                (pointsEqual(face1.getPointB(), face2.getPointA())  ||
                pointsEqual(face1.getPointB(), face2.getPointB())   ||
                pointsEqual(face1.getPointB(), face2.getPointC()))
                &&
                (pointsEqual(face1.getPointC(), face2.getPointA())  ||
                pointsEqual(face1.getPointC(), face2.getPointB())   ||
                pointsEqual(face1.getPointC(), face2.getPointC()))) {

            return true;
        }
        return false;
    }
}
