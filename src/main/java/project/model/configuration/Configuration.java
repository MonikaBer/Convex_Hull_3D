package project.model.configuration;

public class Configuration {

    private CuboidGeneratorConfiguration cuboidGeneratorConfiguration;
    private BallGeneratorConfiguration ballGeneratorConfiguration;
    private SphereGeneratorConfiguration sphereGeneratorConfiguration;
    private Class simplificationType;

    public Configuration(CuboidGeneratorConfiguration cuboidGeneratorConfiguration,
                         BallGeneratorConfiguration ballGeneratorConfiguration,
                         SphereGeneratorConfiguration sphereGeneratorConfiguration,
                         Class simplificationType) {

        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
        this.ballGeneratorConfiguration = ballGeneratorConfiguration;
        this.sphereGeneratorConfiguration = sphereGeneratorConfiguration;
        this.simplificationType = simplificationType;
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
}
