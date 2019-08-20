package main.java.com.BehavioralPatterns.visitor.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-20
 */
public class Computer implements Item {
    private int cost;
    private String serialNumber;

    public Computer(int cost, String serialNumber) {
        this.cost = cost;
        this.serialNumber = serialNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
