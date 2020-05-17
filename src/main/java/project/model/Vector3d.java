package project.model;

import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;

public class Vector3d extends Point3d {

    public Vector3d(double x, double y, double z) {
        super(x, y, z);
    }

    public Vector3d(double[] p) {
        super(p);
    }

    public Vector3d(Point3d p1) {
        super(p1);
    }

    public Vector3d(Point3f p1) {
        super(p1);
    }

    public Vector3d(Tuple3f t1) {
        super(t1);
    }

    public Vector3d(Tuple3d t1) {
        super(t1);
    }

    public Vector3d() {
        super();
    }
}
