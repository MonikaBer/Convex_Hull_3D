package project.model.algorithms;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public interface Algorithm {
    ArrayList<Point3d> startAlgorithm(ArrayList<Point3d> points);
}
