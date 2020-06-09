package project.model.algorithms.giftWrappingAlgorithm;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Edge {

    //knows one face (pointA, pointB, knownPointBeyondEdge) and wants to know the second face (by unknown point beyond edge)
    private ArrayList<Point3d> pointsOnEdge;
    private Point3d knownPointBeyondEdge;
    //private Point3d unknownPointBeyondEdge = null;

    public Edge(Point3d pointA, Point3d pointB, Point3d knownPointBeyondEdge) {
        pointsOnEdge.add(pointA);
        pointsOnEdge.add(pointB);
        this.knownPointBeyondEdge = knownPointBeyondEdge;
    }

    public ArrayList<Point3d> getPointsOnEdge() {
        return pointsOnEdge;
    }

    public void setPointsOnEdge(ArrayList<Point3d> pointsOnEdge) {
        this.pointsOnEdge = pointsOnEdge;
    }

    public Point3d getKnownPointBeyondEdge() {
        return knownPointBeyondEdge;
    }

    public void setKnownPointBeyondEdge(Point3d knownPointBeyondEdge) {
        this.knownPointBeyondEdge = knownPointBeyondEdge;
    }
//
//    public Point3d getUnknownPointBeyondEdge() {
//        return unknownPointBeyondEdge;
//    }
//
//    public void setUnknownPointBeyondEdge(Point3d unknownPointBeyondEdge) {
//        this.unknownPointBeyondEdge = unknownPointBeyondEdge;
//    }
}
