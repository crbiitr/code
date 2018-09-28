package main.java.com.structuralPatterns.decorator_pattern.BeverageDecoratorDemo;

/**
 * Created by Chetan Raj on 10/25/16.
 */
class SugarDecorator extends BeverageDecorator{
    public SugarDecorator(Beverage beverage){
        super(beverage);
    }
    public void decorateBeverage(){
        super.decorateBeverage();
        decorateSugar();
    }
    public void decorateSugar(){
        System.out.println("Added Sugar to:"+beverage.getName());
    }
    public int getIncrementPrice(){
        return 5;
    }
    public String getDecoratedName(){
        return "Sugar";
    }
}
