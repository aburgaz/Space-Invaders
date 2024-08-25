package tp1.logic.Command.NoParamsCommand;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand {  
	@Override 
	public boolean execute(GameModel game) {
		game.exit();   
		return false;
	}

	// GETTERS
	@Override 
	protected String getName() {    
		return Messages.COMMAND_EXIT_NAME;  
	} 
	@Override 
	protected String getShortcut() {   
		return Messages.COMMAND_EXIT_SHORTCUT;  
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_EXIT_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_EXIT_HELP;
	}
}
