package main.java.com.BehavioralPatterns.Command.Demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * The type SwitchTheInvoker.
 *
 * @author Chetan Raj
 * @implNote This is the INVOKER
 * @since : 07/02/19
 */
public class SwitchTheInvoker {
	private List<Command> commandHistoryList = new ArrayList<>();

	/**
	 * Instantiates a new SwitchTheInvoker.
	 *
	 * @param commandHistoryList the command history list
	 */
	public SwitchTheInvoker(List<Command> commandHistoryList) {
		this.commandHistoryList = commandHistoryList;
	}

	/**
	 * Instantiates a new SwitchTheInvoker.
	 */
	public SwitchTheInvoker() {
	}

	/**
	 * Gets command history list.
	 *
	 * @return the command history list
	 */
	public List<Command> getCommandHistoryList() {
		return commandHistoryList;
	}

	/**
	 * Sets command history list.
	 *
	 * @param commandHistoryList the command history list
	 */
	public void setCommandHistoryList(List<Command> commandHistoryList) {
		this.commandHistoryList = commandHistoryList;
	}

	/**
	 * To Store and execute the command.
	 *
	 * @param command the command
	 */
	public void storeAndExecute(Command command) {
		commandHistoryList.add(command);
		command.execute();
	}
}
