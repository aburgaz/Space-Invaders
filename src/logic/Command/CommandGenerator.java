package tp1.logic.Command;

import java.util.Arrays;
import java.util.List;

import tp1.control.Exceptions.CommandParseException;
import tp1.logic.Command.NoParamsCommand.*;
import tp1.logic.Command.ParamsCommand.*;
import tp1.view.Messages;


public class CommandGenerator {
	private static final List<Command> AVAILABLE_COMMANDS =    // Lista de posibles Comandos
			Arrays.asList( new ExitCommand(), new HelpCommand(),
						new ListCommand(), new MoveCommand(), new ShootCommand(), new ShockWaveCommand(),
					new ResetCommand(), new NoneCommand(), new SuperLaserCommand(), new MamahuevasoCommand());


	// Parse
	public static Command parse(String[] commandWords) throws CommandParseException{

		Command command = null;   
		for (Command c: AVAILABLE_COMMANDS) { 		// Comprueba el input con la lista de posibles comandos
			command = c.parse(commandWords);
			if (command != null) break;
		}
		
		return command;
	}

}
