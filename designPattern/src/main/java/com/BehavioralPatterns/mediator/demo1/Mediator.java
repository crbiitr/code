package main.java.com.BehavioralPatterns.mediator.demo1;

/**
 * @author Chetan Raj
 * @implNote This code is from book.
 * @since : 23/04/19
 */

// It is a Mediator.
public class Mediator {
    Buyer indianBuyer;
    Buyer frenchBuyer;
    AmericanSeller americanSeller;
    DollarConverter dollarConverter;

    public Mediator() {
    }

    public void registerIndianBuyer(IndianBuyer indianBuyer) {
        this.indianBuyer = indianBuyer;
    }

    public void registerFrenchBuyer(FrenchBuyer frenchBuyer) {
        this.frenchBuyer = frenchBuyer;
    }

    public void registerAmericanSeller(AmericanSeller americanSeller) {
        this.americanSeller = americanSeller;
    }

    public void registerDollerConverter(DollarConverter dollarConverter) {
        this.dollarConverter = dollarConverter;
    }

    public boolean placeBid(float bid, String unitOfCurrency) {
        float dollarAmount = dollarConverter.convertCurrencyToDollar(bid, unitOfCurrency);
        return americanSeller.isBidAccepted(dollarAmount);
    }
}
