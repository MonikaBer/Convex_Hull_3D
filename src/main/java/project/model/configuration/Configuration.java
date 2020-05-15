package project.model.configuration;

public class Configuration {

    private CuboidGeneratorConfiguration cuboidGeneratorConfiguration;
    private BallGeneratorConfiguration ballGeneratorConfiguration;
    private SphereGeneratorConfiguration sphereGeneratorConfiguration;

    public Configuration(CuboidGeneratorConfiguration cuboidGeneratorConfiguration,
                         BallGeneratorConfiguration ballGeneratorConfiguration,
                         SphereGeneratorConfiguration sphereGeneratorConfiguration) {

        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
        this.ballGeneratorConfiguration = ballGeneratorConfiguration;
        this.sphereGeneratorConfiguration = sphereGeneratorConfiguration;
    }

    public CuboidGeneratorConfiguration getCuboidGeneratorConfiguration() {
        return cuboidGeneratorConfiguration;
    }

    public void setCuboidGeneratorConfiguration(CuboidGeneratorConfiguration cuboidGeneratorConfiguration) {
        this.cuboidGeneratorConfiguration = cuboidGeneratorConfiguration;
    }

    public BallGeneratorConfiguration getBallGeneratorConfiguration() {
        return ballGeneratorConfiguration;
    }

    public void setBallGeneratorConfiguration(BallGeneratorConfiguration ballGeneratorConfiguration) {
        this.ballGeneratorConfiguration = ballGeneratorConfiguration;
    }

    public SphereGeneratorConfiguration getSphereGeneratorConfiguration() {
        return sphereGeneratorConfiguration;
    }

    public void setSphereGeneratorConfiguration(SphereGeneratorConfiguration sphereGeneratorConfiguration) {
        this.sphereGeneratorConfiguration = sphereGeneratorConfiguration;
    }
}
