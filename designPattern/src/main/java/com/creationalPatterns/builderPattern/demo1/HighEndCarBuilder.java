package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 26/04/15.
 * Concrete Builder class
 */
public class HighEndCarBuilder implements CarBuilder {

    private Car car;
    public HighEndCarBuilder() {
        car = new Car();
    }
    public void buildBase() {
        car.setBase("High priced base");
    }
    public void buildWheels() {
        car.setWheels("Good Tyres");
    }
    public void buildEngine() {
        car.setEngine("High Quality Engine");
    }
    public void buildRoof() {
        car.setRoof("Good flexible roof");
    }
    public void buildMirrors() {
        car.setMirrors("Good Mirrors");
    }
    public void buildLights() {
        car.setLights("Quality Lights");
    }
    public void buildInterior() {
        car.setInterior("Quality Interior");
    }
    public Car getCar() {
        return this.car;
    }
}
