package main.java.com.BehavioralPatterns.visitor.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-20
 */
public interface Item {
    int accept(ShoppingCartVisitor visitor);
}
