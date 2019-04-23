package main.java.com.BehavioralPatterns.mediator.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 23/04/19
 */
public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Buyer indianBuyer = new IndianBuyer(mediator, "INR");
        Buyer frenchBuyer = new FrenchBuyer(mediator, "EURO");

        float sellingPriceInDollars = 10.0f;
        AmericanSeller americanSeller = new AmericanSeller(mediator, sellingPriceInDollars);
        DollarConverter dollarConverter = new DollarConverter(mediator);

        float indianBidInInr = 55.0f;
        while (!indianBuyer.attemptToPurchase(indianBidInInr)) {
            indianBidInInr += 15.0f;
        }

        float frenchBidInEuros = 3.0f;
        while (!frenchBuyer.attemptToPurchase(frenchBidInEuros)) {
            frenchBidInEuros += 1.5f;
        }
    }
}
