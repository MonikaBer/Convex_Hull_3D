package project.model.simplifications;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Voxelisation extends PointsSetReducer {

    private Double accuracy;

    public Voxelisation(Double accuracy) {
        super();
        this.accuracy = accuracy;
    }

    @Override
    public ArrayList<Point3d> simplify(ArrayList<Point3d> points) {
        ArrayList<Point3d> reducedPoints = new ArrayList<>();

        pointsLoop:
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < reducedPoints.size(); j++) {
                if (areTwoPointsInTheSameVoxel(points.get(i), reducedPoints.get(j))) {
                    continue pointsLoop;
                }
            }
            reducedPoints.add(points.get(i));
        }

        return reducedPoints;
    }

    private boolean areTwoPointsInTheSameVoxel(Point3d point1, Point3d point2) {
        Double voxelEdge = accuracy / Math.sqrt(3);

        if (Math.abs(point1.x - point2.x) <= voxelEdge && Math.abs(point1.y - point2.y) <= voxelEdge
                && Math.abs(point1.z - point2.z) <= voxelEdge ) {

            return true;
        }
        return false;
    }
}
