package project.model.generators;

import project.model.configuration.BallGeneratorConfiguration;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class BallGenerator implements Generator {

    private BallGeneratorConfiguration ballGeneratorConfiguration;

    public BallGenerator(BallGeneratorConfiguration ballGeneratorConfiguration) {
        this.ballGeneratorConfiguration = ballGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<Point3d>();

        return points;
    }
}
