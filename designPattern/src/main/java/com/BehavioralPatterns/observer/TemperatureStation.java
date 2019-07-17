package main.java.com.BehavioralPatterns.observer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-17
 */
public class TemperatureStation implements TemperatureSubject {
    Set<TemperatureObserver> observersSet;
    int temperature;

    public TemperatureStation(int temperature) {
        this.observersSet = new HashSet<>();
        this.temperature = temperature;
    }

    @Override
    public void addObserver(TemperatureObserver temperatureObserver) {
        observersSet.add(temperatureObserver);
    }

    @Override
    public void removeObserver(TemperatureObserver temperatureObserver) {
        observersSet.remove(temperatureObserver);
    }

    @Override
    public void notifyToObservers() {
        Iterator iterator = observersSet.iterator();
        while (iterator.hasNext()) {
            TemperatureObserver observer = (TemperatureObserver)iterator.next();
            observer.update(temperature);
        }
    }

    public void setTemperature(int newTemperature) {
        temperature = newTemperature;
        notifyToObservers();
    }
}
