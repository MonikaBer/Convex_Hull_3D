package project.model.simplifications;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Voxelisation implements Simplification {

    @Override
    public ArrayList<Point3d> simplify(ArrayList<Point3d> points) {
        //reduce points inside the same voxel
        return points;
    }
}
