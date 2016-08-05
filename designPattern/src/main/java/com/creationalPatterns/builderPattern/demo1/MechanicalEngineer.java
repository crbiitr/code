package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 25/04/15.
 * Director class
 */
public class MechanicalEngineer {
    private CarBuilder carBuilder;
    public MechanicalEngineer(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car getCar() {
        return carBuilder.getCar();
    }

    public void buildCar() {
        carBuilder.buildBase();
        carBuilder.buildEngine();
        carBuilder.buildWheels();
        carBuilder.buildLights();
        carBuilder.buildMirrors();
        carBuilder.buildRoof();
        carBuilder.buildInterior();
    }

}
