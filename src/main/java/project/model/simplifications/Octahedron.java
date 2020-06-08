package project.model.simplifications;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;

public class Octahedron extends PointsSetReducer {

    public Octahedron() {
        super();
    }

    @Override
    public ArrayList<Point3d> simplify(ArrayList<Point3d> points) {
        Point3d maxX = null;
        Point3d minX = null;
        Point3d maxY = null;
        Point3d minY = null;
        Point3d maxZ = null;
        Point3d minZ = null;

        //determine the octahedron
        for (int i = 0; i < points.size(); i++) {
            tryExchange(points.get(i), maxX, "maxX");
            tryExchange(points.get(i), minX, "minX");
            tryExchange(points.get(i), maxY, "maxY");
            tryExchange(points.get(i), minY, "minY");
            tryExchange(points.get(i), maxZ, "maxZ");
            tryExchange(points.get(i), minZ, "minZ");
        }

        ArrayList<Point3d> extremePoints = new ArrayList<>();
        extremePoints.add(maxX);
        extremePoints.add(minX);
        extremePoints.add(maxY);
        extremePoints.add(minY);
        extremePoints.add(maxZ);
        extremePoints.add(minZ);

        leaveOnlyUniqueExtremePoints(extremePoints);

        //reduce points inside the octahedron
        if (extremePoints.size() < 4)
            return points;

        for (int i = 0; i < points.size(); i++) {
            if (isPointInsideOctahedron(points.get(i), extremePoints)) {
                points.remove(i);
                i--;
            }
        }

        for (int i = 0; i < extremePoints.size(); i++) {
            points.add(extremePoints.get(i));
        }

        return points;
    }

    private void tryExchange(Point3d potentialMinOrMaxPoint, Point3d earlierMinOrMaxPoint, String comparisonType) {
        if (earlierMinOrMaxPoint != null) {
            if (comparisonType.equals("maxX")) {
                if (potentialMinOrMaxPoint.x > earlierMinOrMaxPoint.x) {
                    earlierMinOrMaxPoint = potentialMinOrMaxPoint;
                }
            } else if (comparisonType.equals("minX")) {
                if (potentialMinOrMaxPoint.x < earlierMinOrMaxPoint.x) {
                    earlierMinOrMaxPoint = potentialMinOrMaxPoint;
                }
            } else if (comparisonType.equals("maxY")) {
                if (potentialMinOrMaxPoint.y > earlierMinOrMaxPoint.y) {
                    earlierMinOrMaxPoint = potentialMinOrMaxPoint;
                }
            } else if (comparisonType.equals("minY")) {
                if (potentialMinOrMaxPoint.y < earlierMinOrMaxPoint.y) {
                    earlierMinOrMaxPoint = potentialMinOrMaxPoint;
                }
            } else if (comparisonType.equals("maxZ")) {
                if (potentialMinOrMaxPoint.z > earlierMinOrMaxPoint.z) {
                    earlierMinOrMaxPoint = potentialMinOrMaxPoint;
                }
            } else if (comparisonType.equals("minZ")) {
                if (potentialMinOrMaxPoint.z < earlierMinOrMaxPoint.z) {
                    earlierMinOrMaxPoint = potentialMinOrMaxPoint;
                }
            }
        } else {
            earlierMinOrMaxPoint = potentialMinOrMaxPoint;
        }
    }

    private void leaveOnlyUniqueExtremePoints(ArrayList<Point3d> extremePoints) {
        for (int i = 0; i < extremePoints.size(); i++) {
            for (int j = i+1; j < extremePoints.size(); j++) {
                if (pointsEqual(extremePoints.get(i), extremePoints.get(j))) {
                    extremePoints.remove(j);
                    j--;
                }
            }
        }
    }

    private boolean pointsEqual(Point3d point1, Point3d point2) {
        if (point1.x == point2.x && point1.y == point2.y && point1.z == point2.z)
            return true;
        return false;
    }

    private boolean isPointInsideOctahedron(Point3d checkedPoint, ArrayList<Point3d> extremePoints) {
        for (int i = 0; i < extremePoints.size(); i++) {
            for (int j = i+1; j < extremePoints.size(); j++) {
                for (int k = j+1; k < extremePoints.size(); k++) {
                    for (int l = k+1; l < extremePoints.size(); l++) {
                        if (isPointInsideTetrahedron(extremePoints.get(i), extremePoints.get(j), extremePoints.get(k),
                                                     extremePoints.get(l), checkedPoint)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean sameSide(Point3d vertex1, Point3d vertex2, Point3d vertex3, Point3d vertex4, Point3d checkedPoint) {
        Vector3d normal = new Vector3d();
        normal.cross(new Vector3d(vertex2.x - vertex1.x, vertex2.y - vertex1.y, vertex2.z - vertex1.z),
                     new Vector3d(vertex3.x - vertex1.x, vertex3.y - vertex1.y, vertex3.z - vertex1.z));
        double dotVertex4 = normal.dot(new Vector3d(
                                     vertex4.x - vertex1.x, vertex4.y - vertex1.y, vertex4.z - vertex1.z));
        double dotCheckedPoint = normal.dot(new Vector3d(checkedPoint.x - vertex1.x, checkedPoint.y - vertex1.y,
                                                         checkedPoint.z - vertex1.z));
        return Math.signum(dotVertex4) == Math.signum(dotCheckedPoint);
    }

    private boolean isPointInsideTetrahedron(Point3d vertex1, Point3d vertex2, Point3d vertex3, Point3d vertex4,
                                       Point3d checkedPoint) {

        return  sameSide(vertex1, vertex2, vertex3, vertex4, checkedPoint) &&
                sameSide(vertex2, vertex3, vertex4, vertex1, checkedPoint) &&
                sameSide(vertex3, vertex4, vertex1, vertex2, checkedPoint) &&
                sameSide(vertex4, vertex1, vertex2, vertex3, checkedPoint);
    }
}