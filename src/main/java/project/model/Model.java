package project.model;

import project.model.configuration.Configuration;
import project.model.generators.BallGenerator;
import project.model.generators.CuboidGenerator;
import project.model.generators.SphereGenerator;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Model {

    private CuboidGenerator cuboidGenerator;
    private BallGenerator ballGenerator;
    private SphereGenerator sphereGenerator;

    private ArrayList<Point3d> cuboidPoints;
    private ArrayList<Point3d> ballPoints;
    private ArrayList<Point3d> spherePoints;

    private ArrayList<Point3d> cuboidPointsNaiveResult;
    private ArrayList<Point3d> ballPointsNaiveResult;
    private ArrayList<Point3d> spherePointsNaiveResult;

    private ArrayList<Point3d> cuboidPointsGiftWrappingResult;
    private ArrayList<Point3d> ballPointsGiftWrappingResult;
    private ArrayList<Point3d> spherePointsGiftWrappingResult;

    private ArrayList<Point3d> cuboidPointsIncrementalHullResult;
    private ArrayList<Point3d> ballPointsIncrementalHullResult;
    private ArrayList<Point3d> spherePointsIncrementalHullResult;

    public Model(){}

    public void startCalculation(Configuration configuration) {
        this.cuboidGenerator = new CuboidGenerator(configuration.getCuboidGeneratorConfiguration());
        this.ballGenerator = new BallGenerator(configuration.getBallGeneratorConfiguration());
        this.sphereGenerator = new SphereGenerator(configuration.getSphereGeneratorConfiguration());

        this.cuboidPoints = this.cuboidGenerator.generate();
        this.ballPoints = this.ballGenerator.generate();
        this.spherePoints = this.sphereGenerator.generate();

//        if (configuration.getSimplificationType().equals("voxelisation")) {
//
//        } else {
//
//        }
    }
}
