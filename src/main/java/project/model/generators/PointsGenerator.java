package project.model.generators;

public abstract class PointsGenerator implements Generator {

    private Integer pointsNumber;

    public PointsGenerator(Integer pointsNumber) {
        this.pointsNumber = pointsNumber;
    }
}
