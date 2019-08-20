package main.java.com.BehavioralPatterns.templateMethod.demo1;

/**
 * @author Chetan Raj
 * @implNote: This example from the book. Good example
 * @since : 2019-08-08
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        Lunch meal1 = new McDonaldMeal();
        meal1.prepareLunch();

        System.out.println();
        Lunch meal2 = new KFCMeal();
        meal2.prepareLunch();
    }
}
