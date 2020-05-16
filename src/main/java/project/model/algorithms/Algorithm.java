package project.model.algorithms;

import project.model.Result;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public interface Algorithm {
    Result startAlgorithm(ArrayList<Point3d> points);
}
