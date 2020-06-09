package project.model.algorithms.incrementalHullAlgorithm;

import project.Helper;
import project.model.Face;
import project.model.Result;
import project.model.algorithms.AlgorithmsHelper;
import project.model.algorithms.ConvexHullAlgorithm;
import project.model.algorithms.giftWrappingAlgorithm.Edge;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class IncrementalHullAlgorithm extends ConvexHullAlgorithm {

    public IncrementalHullAlgorithm() {
        super();
    }

    @Override
    public Result startAlgorithm(ArrayList<Point3d> points) {
        ArrayList<Face> convexHullFaces = new ArrayList<>();
        ArrayList<Point3d> convexHullPoints = new ArrayList<>();
        //set runtime
        double runtime = 0.0;

        //find first four points of the convex hull
        //find first face
        Face face = AlgorithmsHelper.findFirstFace(points);
        //add first face to the convex hull
        convexHullFaces.add(face);
        //add points from the first face to the convex hull points
        convexHullPoints.add(face.getPointA());
        convexHullPoints.add(face.getPointB());
        convexHullPoints.add(face.getPointC());
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

        //add the fourth point to the convex hull points
        convexHullPoints.add(pointWithMinAngle);

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

            tmpFaces.clear();
            for (int f = 0; f < convexHullFaces.size(); f++) {
                if (countTetrahedronVolume(convexHullFaces.get(f), points.get(j)) < 0) {
                    //face f is visible for point j, so add this face to tmpFaces
                    tmpFaces.add(convexHullFaces.get(f));
                }
            }
            if (tmpFaces.size() == 0) {
                //no faces visible for point j, so discard point j, because this point is inside the convex hull
                continue;
            }

            //TODO: find boundary edges among all visible tmpFaces
            //TODO: for every boundary edge e:
            // create face determined by e and point j and add this face to the convex hull faces
            // and add point j to the convex hull points

            for (int f = 0; f < tmpFaces.size(); f++) {
                //TODO: delete face f from the convex hull faces
            }
        }

        //measure time
        return new Result(convexHullFaces, runtime);
    }

    private double countTetrahedronVolume(Face face, Point3d point) {
        //TODO: count tetrahedron volume

    }
}
