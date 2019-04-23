package main.java.com.BehavioralPatterns.mediator.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 23/04/19
 */
public class AmericanSeller {
    Mediator mediator;
    float priceInDollar;

    public AmericanSeller(Mediator mediator, float priceInDollar) {
        this.mediator = mediator;
        this.priceInDollar = priceInDollar;
        this.mediator.registerAmericanSeller(this);
    }

    public boolean isBidAccepted(float bidInDollars) {
        if (bidInDollars >= priceInDollar) {
            System.out.println("Seller accepts bid of " + bidInDollars + " dollars\n");
            return true;
        } else {
            System.out.println("Seller rejects bid of " + bidInDollars + " dollars\n");
            return false;
        }
    }
}
