package project.model.generators;

import project.model.configuration.CuboidGeneratorConfiguration;

import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.Random;

public class CuboidGenerator extends PointsGenerator {

    private CuboidGeneratorConfiguration cuboidGeneratorConfiguration;

    public CuboidGenerator(CuboidGeneratorConfiguration cuboidGeneratorConfiguration, Integer pointsNumber) {
        super(pointsNumber);
        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<>();
        //generate points

        Random r = new Random();
        int x, y, z;
        x = r.nextInt();

        return points;
    }
}
