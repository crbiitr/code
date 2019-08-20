package main.java.com.BehavioralPatterns.visitor.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-20
 */
public class Printer implements Item {
    private int priceOfCartridge;
    private int noOfCartridge;
    private String modelNumber;

    public Printer(int priceOfCartridge, int noOfCartridge, String modelNumber) {
        this.priceOfCartridge = priceOfCartridge;
        this.noOfCartridge = noOfCartridge;
        this.modelNumber = modelNumber;
    }

    public int getPriceOfCartridge() {
        return priceOfCartridge;
    }

    public void setPriceOfCartridge(int priceOfCartridge) {
        this.priceOfCartridge = priceOfCartridge;
    }

    public int getNoOfCartridge() {
        return noOfCartridge;
    }

    public void setNoOfCartridge(int noOfCartridge) {
        this.noOfCartridge = noOfCartridge;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
