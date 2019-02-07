package main.java.com.BehavioralPatterns.Command.Demo1;

/**
 * The type Off command.
 *
 * @author Chetan Raj
 * @implNote Concrete classes of Command interface
 * @since : 07/02/19
 */
public class OffCommand implements Command {

	/**
	 * The Air conditioner.
	 */
	AirConditioner airConditioner;

	/**
	 * Instantiates a new Off command.
	 *
	 * @param airConditioner the air conditioner
	 */
	public OffCommand(AirConditioner airConditioner) {
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
		airConditioner.off();
	}
}
