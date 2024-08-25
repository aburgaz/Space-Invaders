package tp1.logic.Command.NoParamsCommand;

import tp1.control.Exceptions.CommandParseException;
import tp1.logic.Command.Command;
import tp1.view.Messages;

public abstract class NoParamsCommand extends Command {

    // COMANDOS SIN PARAMETROS
    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (matchCommandName(commandWords[0])) {
            if (commandWords.length == 1) {
                return this;
            } else {
                throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
            }
        } else {
            return null;
        }
    }
}
