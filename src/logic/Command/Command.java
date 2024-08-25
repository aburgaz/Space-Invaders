package tp1.logic.Command;

import tp1.control.Exceptions.*;
import tp1.logic.GameModel;

public abstract class Command {  

	// GETTERS
	protected abstract String getName();  
	protected abstract String getShortcut();  
	protected abstract String getDetails();  
	protected abstract String getHelp();

	// EJECUCION
	public abstract boolean execute(GameModel game) throws CommandExecuteException;

	// PARSE
	public abstract Command parse(String[] parameter) throws CommandParseException;

	//MATCHING
	protected boolean matchCommandName(String name) {
		return getShortcut().equalsIgnoreCase(name) || getName().equalsIgnoreCase(name);
	}

	public String helpText() {
		return getDetails() + " : " + getHelp() + "\n"; 
	} 
}
