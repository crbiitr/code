package main.java.com.BehavioralPatterns.templateMethod.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-08
 */
public class KFCMeal extends Lunch{
    @Override
    protected void cleaning() {
        System.out.println("KFC:: cleaning");
    }

    @Override
    protected void cooking() {
        System.out.println("KFC:: I am cooking KFC meal");
    }

    @Override
    protected void prepareIngredients() {
        System.out.println("KFC:: Getting burger, cool drinks");
    }

    protected void eating()  {
        System.out.println("KFC:: Eating");
    }
}
