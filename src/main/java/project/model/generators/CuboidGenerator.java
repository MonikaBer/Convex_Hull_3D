package project.model.generators;

import project.model.configuration.CuboidGeneratorConfiguration;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class CuboidGenerator implements Generator {

    private CuboidGeneratorConfiguration cuboidGeneratorConfiguration;

    public CuboidGenerator(CuboidGeneratorConfiguration cuboidGeneratorConfiguration) {
        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<Point3d>();

        return points;
    }
}
