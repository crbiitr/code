package main.java.com.BehavioralPatterns.interpreter.demo1;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/interpreter-design-pattern/
 * @since : 16/04/19
 */
public interface Expression {
    boolean interpret(String str);
}
