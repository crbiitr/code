package main.java.com.structuralPatterns.decorator_pattern.BeverageDecoratorDemo;

/**
 * Created by Chetan Raj on 10/25/16.
 */
class LemonDecorator extends BeverageDecorator{
    public LemonDecorator(Beverage beverage){
        super(beverage);
    }
    public void decorateBeverage(){
        super.decorateBeverage();
        decorateLemon();
    }
    public void decorateLemon(){
        System.out.println("Added Lemon to:"+beverage.getName());
    }
    public int getIncrementPrice(){
        return 3;
    }
    public String getDecoratedName(){
        return "Lemon";
    }
}
