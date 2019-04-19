package main.java.com.BehavioralPatterns.iterator.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 19/04/19
 */
public class Item {
    String name;
    float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
