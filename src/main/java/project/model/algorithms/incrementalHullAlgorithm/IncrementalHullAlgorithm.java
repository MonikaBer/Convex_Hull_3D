package project.model.algorithms.incrementalHullAlgorithm;

import project.Helper;
import project.model.Face;
import project.model.Result;
import project.model.algorithms.AlgorithmsHelper;
import project.model.algorithms.ConvexHullAlgorithm;
import project.model.algorithms.Edge;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class IncrementalHullAlgorithm extends ConvexHullAlgorithm {

    public IncrementalHullAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHullFaces = new ArrayList<>();
        ArrayList<Edge> openEdges = new ArrayList<>();
        //set runtime
        double runtime = 0.0;

        //find first four points of the convex hull
        //find first face
        Face face = AlgorithmsHelper.findFirstFace(points);
        //add first face to the convex hull
        convexHullFaces.add(face);
        //find the fourth point of convex hull (by using gift wrapping method to this point)
        //edge to check
        Edge edge = new Edge(face.getPointA(), face.getPointB(), face.getPointC());

        Face previousFace = new Face(null, null, null);
        Point3d pointWithMinAngle = new Point3d();
        double minAngle;
        double angle;
        previousFace.setPointA(edge.getPointsOnEdge().get(0));
        previousFace.setPointB(edge.getPointsOnEdge().get(1));
        previousFace.setPointC(edge.getKnownPointBeyondEdge());
        face.setPointA(edge.getPointsOnEdge().get(0));
        face.setPointB(edge.getPointsOnEdge().get(1));
        minAngle = -1.0;
        for (int j = 0; j < points.size(); j++) {
            if (Helper.pointsEqual(points.get(j), edge.getPointsOnEdge().get(0)) ||
                    Helper.pointsEqual(points.get(j), edge.getPointsOnEdge().get(1)) ||
                    Helper.pointsEqual(points.get(j), edge.getKnownPointBeyondEdge())) {
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

        //add three new faces to convex hull faces
        convexHullFaces.add(new Face(edge.getPointsOnEdge().get(0),
                                     previousFace.getPointC(),
                                     pointWithMinAngle));

        convexHullFaces.add(new Face(previousFace.getPointC(),
                                     edge.getPointsOnEdge().get(1),
                                     pointWithMinAngle));

        convexHullFaces.add(new Face(edge.getPointsOnEdge().get(1),
                                     edge.getPointsOnEdge().get(0),
                                     pointWithMinAngle));

        ArrayList<Face> tmpFaces = new ArrayList<>();
        //incremental building of convex hull
        for (int j = 0; j < points.size(); j++) {
            if (Helper.pointsEqual(points.get(j), edge.getPointsOnEdge().get(0)) ||
                    Helper.pointsEqual(points.get(j), edge.getPointsOnEdge().get(1)) ||
                    Helper.pointsEqual(points.get(j), edge.getKnownPointBeyondEdge()) ||
                    (Helper.pointsEqual(points.get(j), pointWithMinAngle))) {
                continue;
            }
            openEdges.clear();
            //tmpFaces.clear();
            for (int f = 0; f < convexHullFaces.size(); f++) {
                if (countTetrahedronVolume(convexHullFaces.get(f), points.get(j)) < 0) {
                    //face f is visible for point j, so add this face to tmpFaces
                    //tmpFaces.add(convexHullFaces.get(f));
                    convexHullFaces.remove(f);
                    f--;
                    //add open edges if there are open (extreme)
                    if (!isEdgeInOpenEdges(convexHullFaces.get(f).getPointA(), convexHullFaces.get(f).getPointB(),
                            convexHullFaces.get(f).getPointC(), openEdges)) {

                        openEdges.add(new Edge(convexHullFaces.get(f).getPointA(), convexHullFaces.get(f).getPointB(),
                                convexHullFaces.get(f).getPointC()));
                    }
                    if (!isEdgeInOpenEdges(convexHullFaces.get(f).getPointA(), convexHullFaces.get(f).getPointC(),
                            convexHullFaces.get(f).getPointB(), openEdges)) {

                        openEdges.add(new Edge(convexHullFaces.get(f).getPointA(), convexHullFaces.get(f).getPointC(),
                                convexHullFaces.get(f).getPointB()));
                    }
                    if (!isEdgeInOpenEdges(convexHullFaces.get(f).getPointB(), convexHullFaces.get(f).getPointC(),
                            convexHullFaces.get(f).getPointA(), openEdges)) {

                        openEdges.add(new Edge(convexHullFaces.get(f).getPointB(), convexHullFaces.get(f).getPointC(),
                                convexHullFaces.get(f).getPointA()));
                    }
                }
            }
//            if (tmpFaces.size() == 0) {
//                //no faces visible for point j, so discard point j, because this point is inside the convex hull
//                continue;
//            }
            if (openEdges.size() == 0) {
                //no faces visible for point j, so discard point j, because this point is inside the convex hull
                continue;
            }
            //point j is on the convex hull:
            //TODO: find boundary edges among all visible faces
            for (int e = 0; e < openEdges.size(); e++) {
                // create face determined by e and point j and add this face to the convex hull faces
                convexHullFaces.add(new Face(openEdges.get(e).getPointsOnEdge().get(0),
                                             openEdges.get(e).getPointsOnEdge().get(1),
                                             points.get(j)));
            }
        }

        System.out.println("Incremental Hull Algorithm finished");

        //measure time
        return new Result(convexHullFaces, runtime, points);
    }

    private double countTetrahedronVolume(Face face, Point3d point) {
        double[][] matrix = new double[4][4];
        //complete matrix
        matrix[0][0] = face.getPointA().x;
        matrix[0][1] = face.getPointA().y;
        matrix[0][2] = face.getPointA().z;
        matrix[0][3] = 1;

        matrix[1][0] = face.getPointB().x;
        matrix[1][1] = face.getPointB().y;
        matrix[1][2] = face.getPointB().z;
        matrix[1][3] = 1;

        matrix[2][0] = face.getPointC().x;
        matrix[2][1] = face.getPointC().y;
        matrix[2][2] = face.getPointC().z;
        matrix[2][3] = 1;

        matrix[3][0] = point.x;
        matrix[3][1] = point.y;
        matrix[3][2] = point.z;
        matrix[3][3] = 1;

        //count determinant of matrix
        double det = matrix[0][0] * (matrix[1][1]*matrix[2][2]*matrix[3][3] +
                                     matrix[2][1]*matrix[3][2]*matrix[1][3] +
                                     matrix[3][1]*matrix[1][2]*matrix[2][3] -
                                     matrix[2][1]*matrix[1][2]*matrix[3][3] -
                                     matrix[1][1]*matrix[3][2]*matrix[2][3] -
                                     matrix[3][1]*matrix[2][2]*matrix[1][3]) -

                     matrix[0][1] * (matrix[1][0]*matrix[2][2]*matrix[3][3] +
                                     matrix[2][0]*matrix[3][2]*matrix[1][3] +
                                     matrix[3][0]*matrix[1][2]*matrix[2][3] -
                                     matrix[2][0]*matrix[1][2]*matrix[3][3] -
                                     matrix[1][0]*matrix[3][2]*matrix[2][3] -
                                     matrix[3][0]*matrix[2][2]*matrix[1][3]) +

                     matrix[0][2] * (matrix[1][0]*matrix[2][1]*matrix[3][3] +
                                     matrix[2][0]*matrix[3][1]*matrix[1][3] +
                                     matrix[3][0]*matrix[1][1]*matrix[2][3] -
                                     matrix[2][0]*matrix[1][1]*matrix[3][3] -
                                     matrix[1][0]*matrix[3][1]*matrix[2][3] -
                                     matrix[3][0]*matrix[2][1]*matrix[1][3]) -

                     matrix[0][3] * (matrix[1][0]*matrix[2][1]*matrix[3][2] +
                                     matrix[2][0]*matrix[3][1]*matrix[1][2] +
                                     matrix[3][0]*matrix[1][1]*matrix[2][2] -
                                     matrix[2][0]*matrix[1][1]*matrix[3][2] -
                                     matrix[1][0]*matrix[3][1]*matrix[2][2] -
                                     matrix[3][0]*matrix[2][1]*matrix[1][2]);
        return det;
    }

    private boolean isEdgeInOpenEdges(Point3d pointA, Point3d pointB, Point3d pointC, ArrayList<Edge> openEdges) {
        for (int e = 0; e < openEdges.size(); e++) {
            if (((pointA == openEdges.get(e).getPointsOnEdge().get(0) && pointB == openEdges.get(e).getPointsOnEdge().get(1)) ||
                    (pointA == openEdges.get(e).getPointsOnEdge().get(1) && pointB == openEdges.get(e).getPointsOnEdge().get(0))) &&
                    (pointC == openEdges.get(e).getKnownPointBeyondEdge())) {
                return true;
            }
        }
        return false;
    }
}
