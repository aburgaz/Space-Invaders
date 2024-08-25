package tp1.logic.Command.ParamsCommand;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.control.Exceptions.CommandParseException;
import tp1.control.Exceptions.InitializationException;
import tp1.control.InitialConfiguration;
import tp1.logic.Command.Command;
import tp1.logic.GameModel;
import tp1.view.Messages;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.file.InvalidPathException;

public class ResetCommand extends Command {
    private InitialConfiguration config;

    @Override
    public boolean execute(GameModel game) throws CommandExecuteException {

        if (config.equals(InitialConfiguration.NONE)) {
            game.reset();

        } else {
            try {
                game.resetConfiguration(config);
            } catch (InitializationException e) {
                throw new CommandExecuteException(e.getMessage());
            }
        }

        return true;
    }


    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_RESET_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_RESET_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_RESET_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_RESET_HELP;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {

        if (matchCommandName(commandWords[0])) {
            try {
                config = InitialConfiguration.NONE;
                if (commandWords.length <= 2){
                    config = InitialConfiguration.readFromFile(commandWords[1]);
                    return this;
                }
                else{
                    throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
                }
            } catch (InvalidPathException | IOException e) {
                throw new CommandParseException(String.format(Messages.FILE_NOT_FOUND, commandWords[1]));
            } catch (IndexOutOfBoundsException e) {
                return this;
            }
        } else return null;
    }
}
