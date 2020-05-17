package project.model.generators;

public abstract class PointsGenerator implements Generator {

    protected Integer pointsNumber;

    public PointsGenerator(Integer pointsNumber) {
        this.pointsNumber = pointsNumber;
    }
}
