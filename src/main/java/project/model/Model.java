package project.model;

import project.model.algorithms.ConvexHullAlgorithm;
import project.model.algorithms.giftWrappingAlgorithm.GiftWrappingAlgorithm;
import project.model.algorithms.incrementalHullAlgorithm.IncrementalHullAlgorithm;
import project.model.algorithms.naiveAlgorithm.NaiveAlgorithm;
import project.model.configuration.Configuration;
import project.model.generators.BallGenerator;
import project.model.generators.CuboidGenerator;
import project.model.generators.PointsGenerator;
import project.model.generators.SphereGenerator;
import project.model.pointsSets.BallPointsSet;
import project.model.pointsSets.CuboidPointsSet;
import project.model.pointsSets.PointsSet;
import project.model.pointsSets.SpherePointsSet;
import project.model.simplifications.Octahedron;
import project.model.simplifications.PointsSetReducer;
import project.model.simplifications.Voxelisation;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class Model {

    private ArrayList<PointsGenerator> generators;
    private ArrayList<ConvexHullAlgorithm> algorithms;
    private ArrayList<PointsSet> pointsSets;
    private PointsSetReducer pointsSetReducer;

    public Model(){
        this.generators = new ArrayList<>();
        this.algorithms = new ArrayList<>();
        this.pointsSets = new ArrayList<>();
    }

    public void initGenerators(Configuration configuration) {
        this.generators.add(new CuboidGenerator(configuration.getCuboidGeneratorConfiguration(),
                configuration.getPointsNumber()));
        this.generators.add(new BallGenerator(configuration.getBallGeneratorConfiguration(),
                configuration.getPointsNumber()));
        this.generators.add(new SphereGenerator(configuration.getSphereGeneratorConfiguration(),
                configuration.getPointsNumber()));

        if (configuration.getSimplificationType() == Voxelisation.class) {
            this.pointsSetReducer = new Voxelisation(configuration.getAccuracy());
        } else {
            this.pointsSetReducer = new Octahedron();
        }
    }

    public void createAlgorithmsList() {
        this.algorithms.add(new NaiveAlgorithm());
        this.algorithms.add(new GiftWrappingAlgorithm());
        this.algorithms.add(new IncrementalHullAlgorithm());
    }

    public void generatePoints() {
        this.pointsSets.add(new CuboidPointsSet());
        this.pointsSets.add(new BallPointsSet());
        this.pointsSets.add(new SpherePointsSet());

        for (int i = 0; i < this.pointsSets.size(); i++) {
            this.pointsSets.get(i).setPoints(this.generators.get(i).generate());
        }
    }

    public void reducePoints() {
        for (int i = 0; i < this.pointsSets.size(); i++) {
            this.pointsSets.get(i).setPoints(this.pointsSetReducer.simplify(this.pointsSets.get(i).getPoints()));
        }
    }

    public ArrayList<Result> startAlgorithms() {
        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i < this.pointsSets.size(); i++) {
            for (int j = 0; j < this.algorithms.size(); j++) {
                if (j != 0) {
                    ArrayList<Face> emptyPoints = new ArrayList<>();
                    ArrayList<Point3d> emptyInputPoints = new ArrayList<>();
                    results.add(new Result(emptyPoints, 1.0, emptyInputPoints));
                    continue;
                }
                results.add(this.algorithms.get(j).startAlgorithm(this.pointsSets.get(i).getPoints()));
            }
        }
        return results;
    }
}
