package project.model;

import java.util.ArrayList;

public class Result {

    private ArrayList<Face> result;
    private double runtime;

    public Result(ArrayList<Face> result, double runtime) {
        this.result = result;
        this.runtime = runtime;
    }

    public ArrayList<Face> getResult() {
        return result;
    }

    public double getRuntime() {
        return runtime;
    }
}
