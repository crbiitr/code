package main.java.com.BehavioralPatterns.ChainOfResponsibility.CORDemo1;

/**
 * Created by user on 12/5/16.
 */
public abstract class AbstractLogger {

    public final static int INFO  = 1;
    public final static int DEBUG  = 2;
    public final static int ERROR  = 3;

    //next element in chain or responsibility
    protected AbstractLogger nextLogger;
    protected int level;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            this.write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}
