package main.java.com.creationalPatterns.builderPattern.demo1;

/**
 * Created by chetan.bharti on 25/04/15.
 * Concrete product class
 */
public class Car implements CarPlan {

    private String base;
    private String wheels;
    private String engine;
    private String roof;
    private String mirrors;
    private String lights;
    private String interior;

    public void setBase(String b) {
        this.base = b;
    }
    public void setWheels(String w) {
        this.wheels = w;
    }
    public void setEngine(String e) {
        this.engine = e;
    }
    public void setRoof(String r) {
        this.roof = r;
    }
    public void setMirrors(String m) {
        this.mirrors = m;
    }
    public void setLights(String l) {
        this.lights = l;
    }
    public void setInterior(String i) {
        this.interior = i;
    }
}
