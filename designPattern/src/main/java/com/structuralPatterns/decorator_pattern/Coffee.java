package main.java.com.structuralPatterns.decorator_pattern;

/**
 * Created by user on 10/25/16.
 */
class Coffee extends Beverage{
    public Coffee(String name){
        super(name);
        setPrice(15);
    }
    public void decorateBeverage(){
        System.out.println("Cost of: "+ name +" is:  "+ price);
        // You can add some more functionality
    }
}
