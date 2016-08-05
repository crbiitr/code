package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 25/04/15.
 * Builder Interface
 */
public interface CarBuilder {
    public void buildBase();
    public void buildWheels();
    public void buildEngine();
    public void buildRoof();
    public void buildMirrors();
    public void buildLights();
    public void buildInterior();
    public Car getCar();
}
