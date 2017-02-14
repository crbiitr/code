package main.java.com.BehavioralPatterns.ChainOfResponsibility.CORDemo1;

/**
 * Created by user on 12/5/16.
 * http://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
 */
public class CoRDemo {
    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an Error information");
    }
}
