package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 25/04/15.
 * Concrete Builder class
 */
public class LowPriceCarBuilder implements CarBuilder {

    private Car car;
    public LowPriceCarBuilder() {
        car = new Car();
    }
    public void buildBase() {
        car.setBase("Low priced base");
    }
    public void buildWheels() {
        car.setWheels("Cheap Tyres");
    }
    public void buildEngine() {
        car.setEngine("Low Quality Engine");
    }
    public void buildRoof() {
        car.setRoof("No flexible roof");
    }
    public void buildMirrors() {
        car.setMirrors("Cheap Mirrors");
    }
    public void buildLights() {
        car.setLights("Cheap Lights");
    }
    public void buildInterior() {
        car.setInterior("Cheap Interior");
    }
    public Car getCar() {
        return this.car;
    }
}

