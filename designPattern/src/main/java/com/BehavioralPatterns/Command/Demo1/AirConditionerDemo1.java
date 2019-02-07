package main.java.com.BehavioralPatterns.Command.Demo1;

import java.util.Scanner;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 07/02/19
 */
public class AirConditionerDemo1 {
	public static void main(String[] args) {
		AirConditioner airConditioner = new AirConditioner();
		Command on = new OnCommand(airConditioner);
		Command off = new OffCommand(airConditioner);

		SwitchTheInvoker aSwitchTheInvoker = new SwitchTheInvoker();

		Scanner scanner = new Scanner(System.in);
		String command = null;
		while (!(command = scanner.nextLine()).equalsIgnoreCase("exit")) {
			if (command.equalsIgnoreCase("on")) {
				aSwitchTheInvoker.storeAndExecute(on);
			} else if (command.equalsIgnoreCase("off")) {
				aSwitchTheInvoker.storeAndExecute(off);
			}
		}
		//You can also print the commands, But need to do some changes
		//aSwitchTheInvoker.getCommandHistoryList().forEach(System.out::println);
	}
}
