package project.model.generators;

public abstract class PointsGenerator implements Generator {

    protected int pointsNumber;

    public PointsGenerator(int pointsNumber) {
        this.pointsNumber = pointsNumber;
    }
}
