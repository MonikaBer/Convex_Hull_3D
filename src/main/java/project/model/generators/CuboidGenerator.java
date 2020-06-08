package project.model.generators;

import project.model.configuration.CuboidGeneratorConfiguration;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.Random;

public class CuboidGenerator extends PointsGenerator {

    private final CuboidGeneratorConfiguration cuboidGeneratorConfiguration;

    public CuboidGenerator(CuboidGeneratorConfiguration cuboidGeneratorConfiguration, int pointsNumber) {
        super(pointsNumber);
        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
    }

    @Override
    public ArrayList<Point3d> generate() {
        ArrayList<Point3d> points = new ArrayList<>();
        Random random = new Random();
        double numberA, numberB, numberC;
        Vector3d tempVectorA = new Vector3d();
        Vector3d tempVectorB = new Vector3d();
        Vector3d tempVectorC = new Vector3d();
        double x, y, z;

        for (int i = 0; i < this.pointsNumber; i++) {
            numberA = random.nextDouble();
            numberB = random.nextDouble();
            numberC = random.nextDouble();

            tempVectorA.x = this.cuboidGeneratorConfiguration.getVectorA().x * numberA;
            tempVectorA.y = this.cuboidGeneratorConfiguration.getVectorA().y * numberA;
            tempVectorA.z = this.cuboidGeneratorConfiguration.getVectorA().z * numberA;

            tempVectorB.x = this.cuboidGeneratorConfiguration.getVectorB().x * numberB;
            tempVectorB.y = this.cuboidGeneratorConfiguration.getVectorB().y * numberB;
            tempVectorB.z = this.cuboidGeneratorConfiguration.getVectorB().z * numberB;

            tempVectorC.x = this.cuboidGeneratorConfiguration.getVectorC().x * numberC;
            tempVectorC.y = this.cuboidGeneratorConfiguration.getVectorC().y * numberC;
            tempVectorC.z = this.cuboidGeneratorConfiguration.getVectorC().z * numberC;

            x = this.cuboidGeneratorConfiguration.getMainPoint().x + tempVectorA.x + tempVectorB.x + tempVectorC.x;
            y = this.cuboidGeneratorConfiguration.getMainPoint().y + tempVectorA.y + tempVectorB.y + tempVectorC.y;
            z = this.cuboidGeneratorConfiguration.getMainPoint().z + tempVectorA.z + tempVectorB.z + tempVectorC.z;

            points.add(new Point3d(x, y, z));
        }
        return points;
    }
}
