package project.model.generators;

import project.model.configuration.BallGeneratorConfiguration;

import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.Random;

public class BallGenerator extends PointsGenerator {

    private final BallGeneratorConfiguration ballGeneratorConfiguration;

    public BallGenerator(BallGeneratorConfiguration ballGeneratorConfiguration, Integer pointsNumber) {
        super(pointsNumber);
        this.ballGeneratorConfiguration = ballGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<>();
        Random random = new Random();
        double tempX, tempY, tempZ, x, y, z;

        for (int i = 0; i < this.pointsNumber; i++) {
            tempX = -1D + random.nextDouble() * 2D;                   //from -1 to 1
            tempY = -1D + random.nextDouble() * 2D;                   //from -1 to 1
            tempZ = -1D + random.nextDouble() * 2D;                   //from -1 to 1

            tempX *= this.ballGeneratorConfiguration.getRadius();
            tempY *= this.ballGeneratorConfiguration.getRadius();
            tempZ *= this.ballGeneratorConfiguration.getRadius();

            x = tempX + this.ballGeneratorConfiguration.getCenter().x;
            y = tempY + this.ballGeneratorConfiguration.getCenter().y;
            z = tempZ + this.ballGeneratorConfiguration.getCenter().z;

            Point3d point = new Point3d(x, y, z);

            //check if point (x,y,z) is inside the ball
            if (point.distance(this.ballGeneratorConfiguration.getCenter()) <=
                    this.ballGeneratorConfiguration.getRadius()) {

                points.add(point);
            }
        }
        return points;
    }
}
