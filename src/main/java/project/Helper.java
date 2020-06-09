package project;

import javax.vecmath.Point3d;

public class Helper {

    public static boolean pointsEqual(Point3d point1, Point3d point2) {
        if (point1.x == point2.x && point1.y == point2.y && point1.z == point2.z)
            return true;
        return false;
    }
}
