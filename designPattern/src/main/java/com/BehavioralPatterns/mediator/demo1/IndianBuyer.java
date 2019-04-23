package main.java.com.BehavioralPatterns.mediator.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 23/04/19
 */
public class IndianBuyer extends Buyer {
    public IndianBuyer(Mediator mediator, String unitOfCurrency) {
        super(mediator, unitOfCurrency);
        this.mediator.registerIndianBuyer(this);
    }
}
