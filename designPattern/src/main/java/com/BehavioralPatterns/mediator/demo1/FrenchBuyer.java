package main.java.com.BehavioralPatterns.mediator.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 23/04/19
 */
public class FrenchBuyer extends Buyer {
    public FrenchBuyer(Mediator mediator, String unitOfCurrency) {
        super(mediator, unitOfCurrency);
        this.mediator.registerFrenchBuyer(this);
    }
}
