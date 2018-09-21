package main.java.com.structuralPatterns.decorator_pattern.BeverageDecoratorDemo;

/**
 * Created by user on 10/25/16.
 */
class Tea extends Beverage{
    public Tea(String name){
        super(name);
        setPrice(10);
    }
    public void decorateBeverage(){
        System.out.println("Cost of: "+ name +" is:  "+ price);
        // You can add some more functionality
    }
}
