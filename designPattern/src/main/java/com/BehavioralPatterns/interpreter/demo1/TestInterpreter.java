package main.java.com.BehavioralPatterns.interpreter.demo1;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/interpreter-design-pattern/
 * @since : 16/04/19
 */
public class TestInterpreter {
    public static void main(String[] args) {
        //String context = "Name1 Name3"; // Result false
        String context = "Name1 Name4"; // Result true

        Expression define = buildInterpreterTree();
        System.out.println(context + " is " + define.interpret(context));
    }

    static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminalExpression("Name1");
        Expression terminal2 = new TerminalExpression("Name2");
        Expression terminal3 = new TerminalExpression("Name3");
        Expression terminal4 = new TerminalExpression("Name4");

        // Name2 OR Name3
        Expression alternation1 = new OrExpression(terminal2, terminal3);

        // Name1 OR (Name2 OR Name3)
        Expression alternation2 = new OrExpression(terminal1, alternation1);

        // Name4 AND (Name1 OR (Name2 OR Name3)
        Expression alternation3 = new AndExpression(terminal4, alternation2);

        return alternation3;
    }

}
