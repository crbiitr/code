package main.java.com.BehavioralPatterns.templateMethod.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-08
 */
public abstract class Lunch {
    // Template Method
    public final void prepareLunch() {
        prepareIngredients();
        cooking();
        eating();
        cleaning();
    }

    protected abstract void cleaning();

    protected void eating() {
        System.out.println("I am eating, please don't disturb me.");
    }

    protected abstract void cooking();

    protected abstract void prepareIngredients();
}
