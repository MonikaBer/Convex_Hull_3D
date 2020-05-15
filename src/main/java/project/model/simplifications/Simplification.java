package project.model.simplifications;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public interface Simplification {
    ArrayList<Point3d> simplify(ArrayList<Point3d> points);
}
