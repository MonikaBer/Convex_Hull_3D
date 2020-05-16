package project.model.configuration;

public class Configuration {

    private CuboidGeneratorConfiguration cuboidGeneratorConfiguration;
    private BallGeneratorConfiguration ballGeneratorConfiguration;
    private SphereGeneratorConfiguration sphereGeneratorConfiguration;
    private Class simplificationType;
    private Double accuracy;
    private Integer pointsNumber;

    public Configuration(CuboidGeneratorConfiguration cuboidGeneratorConfiguration,
                         BallGeneratorConfiguration ballGeneratorConfiguration,
                         SphereGeneratorConfiguration sphereGeneratorConfiguration,
                         Class simplificationType, Double accuracy, Integer pointsNumber) {

        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
        this.ballGeneratorConfiguration = ballGeneratorConfiguration;
        this.sphereGeneratorConfiguration = sphereGeneratorConfiguration;
        this.simplificationType = simplificationType;
        this.accuracy = accuracy;
        this.pointsNumber = pointsNumber;
    }

    public CuboidGeneratorConfiguration getCuboidGeneratorConfiguration() {
        return cuboidGeneratorConfiguration;
    }

    public BallGeneratorConfiguration getBallGeneratorConfiguration() {
        return ballGeneratorConfiguration;
    }

    public SphereGeneratorConfiguration getSphereGeneratorConfiguration() {
        return sphereGeneratorConfiguration;
    }

    public Class getSimplificationType() {
        return simplificationType;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public Integer getPointsNumber() {
        return pointsNumber;
    }
}
