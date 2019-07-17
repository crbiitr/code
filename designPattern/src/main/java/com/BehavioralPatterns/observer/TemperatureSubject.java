package main.java.com.BehavioralPatterns.observer;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-17
 */
public interface TemperatureSubject {
    void addObserver(TemperatureObserver temperatureObserver);
    void removeObserver(TemperatureObserver temperatureObserver);
    void notifyToObservers();
}
