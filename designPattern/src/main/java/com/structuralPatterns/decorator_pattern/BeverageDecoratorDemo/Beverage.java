package main.java.com.structuralPatterns.decorator_pattern.BeverageDecoratorDemo;

/**
 * Created by user on 10/25/16.
 * @implNote In Decorator design pattern, there is always a one Interface/Abstract class which is used by "Decorator Concrete"
 * classes and the Concrete classes of Beverage Interface/Abstract class
 */
abstract class Beverage {
    protected String name;
    protected int price;
    public Beverage(){

    }
    public  Beverage(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    protected void setPrice(int price){
        this.price = price;
    }
    protected int getPrice(){
        return price;
    }
    protected abstract void decorateBeverage();

}
