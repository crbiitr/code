package main.java.com.BehavioralPatterns.templateMethod.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-08
 */
public class McDonaldMeal extends Lunch{
    @Override
    protected void cleaning() {
        System.out.println("McDonald:: cleaning");
    }

    @Override
    protected void cooking() {
        System.out.println("McDonald:: I am cooking KFC meal");
    }

    @Override
    protected void prepareIngredients() {
        System.out.println("McDonald:: Getting burger, cool drinks");
    }
}
