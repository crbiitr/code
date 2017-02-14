package main.java.com.BehavioralPatterns.ChainOfResponsibility.CORDemo1;

/**
 * Created by user on 12/5/16.
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
