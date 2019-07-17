package main.java.com.BehavioralPatterns.observer;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-17
 *
 */
public class TemperatureCustomer1 implements TemperatureObserver {
    @Override
    public void update(int temperature) {
        System.out.println(TemperatureCustomer1.class.getName() +" found temperature as ::" + temperature);
    }
}
