package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 26/04/15.
 * Main class for testing the builder pattern.
 */
public class BuilderPatternMainClass {
    public static void main(String[] args) {
        CarBuilder lowPriceCarBuilder = new LowPriceCarBuilder();
        MechanicalEngineer engineer = new MechanicalEngineer(lowPriceCarBuilder);
        Car car = engineer.getCar();
        System.out.println("Builder Constructed Car" + car);
    }
}
