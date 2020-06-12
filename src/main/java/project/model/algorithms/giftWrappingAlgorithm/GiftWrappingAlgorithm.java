package project.model.algorithms.giftWrappingAlgorithm;

import project.Helper;
import project.model.Face;
import project.model.Result;
import project.model.algorithms.AlgorithmsHelper;
import project.model.algorithms.ConvexHullAlgorithm;
import project.model.algorithms.Edge;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class GiftWrappingAlgorithm extends ConvexHullAlgorithm {

    public GiftWrappingAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHullFaces = new ArrayList<>();
        ArrayList<Edge> openEdges = new ArrayList<>();
        //start runtime
        double runtime = 0.0;

        //find a first face of convex hull
        Face face = AlgorithmsHelper.findFirstFace(points);
        convexHullFaces.add(face);
        openEdges.add(new Edge(face.getPointA(), face.getPointB(), face.getPointC()));
        openEdges.add(new Edge(face.getPointA(), face.getPointC(), face.getPointB()));
        openEdges.add(new Edge(face.getPointB(), face.getPointC(), face.getPointA()));

        Face previousFace = new Face(null, null, null);
        Point3d pointWithMinAngle = new Point3d();
        double minAngle;
        double angle;
        //build the convex hull
        for (int i = 0; i < openEdges.size(); i++) {
            previousFace.setPointA(openEdges.get(i).getPointsOnEdge().get(0));
            previousFace.setPointB(openEdges.get(i).getPointsOnEdge().get(1));
            previousFace.setPointC(openEdges.get(i).getKnownPointBeyondEdge());
            face.setPointA(openEdges.get(i).getPointsOnEdge().get(0));
            face.setPointB(openEdges.get(i).getPointsOnEdge().get(1));
            minAngle = -1.0;
            for (int j = 0; j < points.size(); j++) {
                if (Helper.pointsEqual(points.get(j), openEdges.get(i).getPointsOnEdge().get(0)) ||
                        Helper.pointsEqual(points.get(j), openEdges.get(i).getPointsOnEdge().get(1)) ||
                        Helper.pointsEqual(points.get(j), openEdges.get(i).getKnownPointBeyondEdge())) {
                    continue;
                }
                //create face from points on edge and point j, later measure angle between this face and previous edge's face
                face.setPointC(points.get(j));

                //count angle between this face and previous face
                angle = AlgorithmsHelper.countAngleBetweenFaces(previousFace, face);

                //compare with the previous minimum angle
                if (minAngle == -1.0 || minAngle > angle) {
                    minAngle = angle;
                    pointWithMinAngle = points.get(j);
                }
            }
            //add new face to convex hull faces
            convexHullFaces.add(new Face(openEdges.get(i).getPointsOnEdge().get(0),
                                         openEdges.get(i).getPointsOnEdge().get(1),
                                         pointWithMinAngle));

            //check if any of two new found edges was in openEdges set, if no -> add this edge to openEdges
            //check the first new found edge
            if (!isEdgeInOpenEdges(openEdges.get(i).getPointsOnEdge().get(0), pointWithMinAngle, openEdges)) {
                openEdges.add(new Edge(openEdges.get(i).getPointsOnEdge().get(0),
                                       pointWithMinAngle,
                                       openEdges.get(i).getPointsOnEdge().get(1)));
            }
            //check the second new found edge
            if (!isEdgeInOpenEdges(pointWithMinAngle, openEdges.get(i).getPointsOnEdge().get(1), openEdges)) {
                openEdges.add(new Edge(pointWithMinAngle,
                                       openEdges.get(i).getPointsOnEdge().get(1),
                                       openEdges.get(i).getPointsOnEdge().get(0)));
            }

            //remove considered edge from open edges set
            openEdges.remove(i);    //?
            //undo index (because of removing one edge from open edges set)
            i--;                    //?
        }

        System.out.println("Gift Wrapping Algorithm finished");

        //measure runtime
        return new Result(convexHullFaces, runtime, points);
    }

    private boolean isEdgesEqual(Point3d pointA, Point3d pointB, Edge edge) {
        if ((pointA == edge.getPointsOnEdge().get(0) && pointB == edge.getPointsOnEdge().get(1)) ||
                (pointB == edge.getPointsOnEdge().get(0) && pointA == edge.getPointsOnEdge().get(1))) {
            return true;
        }
        return false;
    }

    private boolean isEdgeInOpenEdges(Point3d pointA, Point3d pointB, ArrayList<Edge> openEdges) {
        for (int i = 0; i < openEdges.size(); i++) {
            if (isEdgesEqual(pointA, pointB, openEdges.get(i))) {
                return true;
            }
        }
        return false;
    }
}
