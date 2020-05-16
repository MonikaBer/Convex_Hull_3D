package project.model.pointsSets;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class PointsSet {

    ArrayList<Point3d> points;

    public PointsSet() {
        this.points = new ArrayList<Point3d>();
    }

    public ArrayList<Point3d> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point3d> points) {
        this.points = points;
    }
}
