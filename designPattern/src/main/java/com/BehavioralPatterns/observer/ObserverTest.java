package main.java.com.BehavioralPatterns.observer;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-17
 * From Book.
 * Suggestion: We don't need to create class for each customer. Just give some id to Customer class
 *              and create new object using new id.
 */
public class ObserverTest {
    public static void main(String[] args) {
        TemperatureStation temperatureStation = new TemperatureStation(25);
        TemperatureCustomer1 customer1 = new TemperatureCustomer1();
        TemperatureCustomer2 customer2 = new TemperatureCustomer2();
        temperatureStation.addObserver(customer1);
        temperatureStation.addObserver(customer2);

        temperatureStation.setTemperature(30);
        temperatureStation.removeObserver(customer1);
        temperatureStation.setTemperature(35);
    }
}
