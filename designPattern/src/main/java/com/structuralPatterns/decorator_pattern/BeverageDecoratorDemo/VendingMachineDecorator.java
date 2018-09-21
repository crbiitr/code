package main.java.com.structuralPatterns.decorator_pattern.BeverageDecoratorDemo;

/**
 * Created by user on 10/25/16.
 */
public class VendingMachineDecorator {
    public static void main(String args[]){
        Beverage beverage = new SugarDecorator(new LemonDecorator(new Tea("Assam Tea")));
        beverage.decorateBeverage();

        System.out.println("\n\nNow preparing Coffee\n");
        beverage = new SugarDecorator(new LemonDecorator(new Coffee("Cappuccino")));
        beverage.decorateBeverage();
    }
}
