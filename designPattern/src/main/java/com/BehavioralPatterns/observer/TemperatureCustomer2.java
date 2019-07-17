package main.java.com.BehavioralPatterns.observer;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-17
 */
public class TemperatureCustomer2 implements TemperatureObserver {
    @Override
    public void update(int temperature) {
        System.out.println(TemperatureCustomer2.class.getName() +" found temperature as ::" + temperature);
    }
}
