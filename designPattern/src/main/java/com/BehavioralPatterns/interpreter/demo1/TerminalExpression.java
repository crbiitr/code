package main.java.com.BehavioralPatterns.interpreter.demo1;

import java.util.StringTokenizer;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 16/04/19
 */

// This is like leaf node in Composite design pattern
public class TerminalExpression implements Expression {
    private String literal = null; // here literal is the context as defined in book.

    public TerminalExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String test = stringTokenizer.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
