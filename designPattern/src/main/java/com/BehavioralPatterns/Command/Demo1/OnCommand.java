package main.java.com.BehavioralPatterns.Command.Demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 07/02/19
 */
public class OnCommand implements Command {

	/**
	 * The Air conditioner.
	 */
	AirConditioner airConditioner;

	/**
	 * Instantiates a new On command.
	 *
	 * @param airConditioner the air conditioner
	 */
	public OnCommand(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}

	/**
	 * Gets air conditioner.
	 *
	 * @return the air conditioner
	 */
	public AirConditioner getAirConditioner() {
		return airConditioner;
	}

	/**
	 * Sets air conditioner.
	 *
	 * @param airConditioner the air conditioner
	 */
	public void setAirConditioner(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}

	/**
	 * Command must have Execute method.
	 */
	@Override
	public void execute() {
		airConditioner.on();
	}
}
