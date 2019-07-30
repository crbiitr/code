package main.java.com.BehavioralPatterns.nullObject.demo1;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-22
 * @Link: https://sourcemaking.com/design_patterns/null_object/java/1
 */
public class NullObjectDemo {
    public static void main(String[] args) {
        Application app = new Application(new NullPrintStream());
        app.doSomething();
    }
}

class NullOutputStream extends OutputStream {
    public void write(int b) {
        // Do nothing
    }
}

class NullPrintStream extends PrintStream {
    public NullPrintStream() {
        super(new NullOutputStream());
    }
}

class Application {
    private PrintStream debugOut;

    public Application(PrintStream debugOut) {
        this.debugOut = debugOut;
    }

    public void doSomething() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            debugOut.println("i = " + i); // It will not print for "NullPrintStream"
        }
        System.out.println("sum = " + sum);
    }
}

