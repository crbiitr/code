package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 25/04/15.
 * Abstract product class
 */
public interface CarPlan {
    public void setBase(String basement);
    public void setWheels(String wheels);
    public void setEngine(String engine);
    public void setRoof(String roof);
    public void setMirrors(String mirrors);
    public void setLights(String lights);
    public void setInterior(String interior);
}
