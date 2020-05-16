package project.model.generators;

import project.model.configuration.SphereGeneratorConfiguration;

import javax.vecmath.Point3d;
import java.util.ArrayList;

public class SphereGenerator extends PointsGenerator  {

    private SphereGeneratorConfiguration sphereGeneratorConfiguration;

    public SphereGenerator(SphereGeneratorConfiguration sphereGeneratorConfiguration) {
        super();
        this.sphereGeneratorConfiguration = sphereGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<Point3d>();
        //generate points
        return points;
    }
}
