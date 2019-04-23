package main.java.com.BehavioralPatterns.mediator.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 23/04/19
 */
public class DollarConverter {
    Mediator mediator;
    public static final float DOLLAR_UNIT = 1.0f;
    public static final float EURO_UNIT = 0.7f;
    public static final float INR_UNIT = 45.0f;

    public DollarConverter(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.registerDollerConverter(this);
    }

    public float convertEuroToDollar(float euros) {
        float dollars = euros * (DOLLAR_UNIT / EURO_UNIT);
        System.out.println("Converting " + euros + " euros to " + dollars + " dollars");
        return dollars;
    }

    public float convertInrToDollar(float inr) {
        float dollars = inr * (DOLLAR_UNIT / INR_UNIT);
        System.out.println("Converting " + inr + " inr to " + dollars + " dollars");
        return dollars;
    }

    public float convertCurrencyToDollar(float amount, String unitOfCurrency) {
        if ("INR".equalsIgnoreCase(unitOfCurrency)) {
            return convertInrToDollar(amount);
        } else {
            return convertEuroToDollar(amount);
        }
    }
}
