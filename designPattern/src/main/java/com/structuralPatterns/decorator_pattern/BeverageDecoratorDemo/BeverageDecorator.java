package main.java.com.structuralPatterns.decorator_pattern.BeverageDecoratorDemo;

/**
 * Created by Chetan Raj on 10/25/16.
 */
abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;
    public BeverageDecorator(Beverage beverage){
        this.beverage = beverage;
        setName(beverage.getName()+"+"+getDecoratedName());
        setPrice(beverage.getPrice()+getIncrementPrice());
    }
    public void decorateBeverage(){
        beverage.decorateBeverage();
        System.out.println("Cost of: "+getName()+" is:  "+getPrice());
    }
    public abstract int getIncrementPrice();
    public abstract String getDecoratedName();
}
