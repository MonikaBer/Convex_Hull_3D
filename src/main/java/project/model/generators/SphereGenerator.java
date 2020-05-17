package project.model.generators;

import project.model.configuration.SphereGeneratorConfiguration;

import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.Random;

public class SphereGenerator extends PointsGenerator  {

    private final SphereGeneratorConfiguration sphereGeneratorConfiguration;

    public SphereGenerator(SphereGeneratorConfiguration sphereGeneratorConfiguration, Integer pointsNumber) {
        super(pointsNumber);
        this.sphereGeneratorConfiguration = sphereGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<>();
        Random random = new Random();
        double x, y, z, tempX, tempY, tempZ, angle, r;

        for (int i = 0; i < this.pointsNumber; i++) {
            tempZ = -this.sphereGeneratorConfiguration.getRadius() + random.nextDouble() *
                    2D * this.sphereGeneratorConfiguration.getRadius();                      //from -r to r
            angle = random.nextDouble() * 360D;                                              //from 0 to 360 degrees

            r = Math.sqrt(Math.pow(this.sphereGeneratorConfiguration.getRadius(),2) - Math.pow(tempZ,2));
            tempX = r * Math.cos(angle);
            tempY = r * Math.sin(angle);

            x = this.sphereGeneratorConfiguration.getCenter().x + tempX;
            y = this.sphereGeneratorConfiguration.getCenter().y + tempY;
            z = this.sphereGeneratorConfiguration.getCenter().z + tempZ;
            points.add(new Point3d(x, y, z));
        }
        return points;
    }
}
