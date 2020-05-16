package project.model.simplifications;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Voxelisation extends PointsSetReducer {

    public Voxelisation() {
        super();
    }

    @Override
    public ArrayList<Point3d> simplify(ArrayList<Point3d> points) {
        //divide the space into voxels and reduce points inside the same voxel
        return points;
    }
}
