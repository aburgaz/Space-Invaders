package tp1.logic.Command.ParamsCommand;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.control.Exceptions.CommandParseException;
import tp1.logic.Command.Command;
import tp1.logic.GameModel;
import tp1.logic.Move;
import tp1.view.Messages;

public class MoveCommand extends Command {

    private Move dir;

    @Override
    public boolean execute(GameModel game) throws CommandExecuteException {

        game.move(dir);
        game.updateGame();
        return true;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (matchCommandName(commandWords[0])) {
            try {
                if (commandWords.length == 2) {
                    dir = Move.StringToEnum(commandWords[1]);

                    if (dir == Move.UP || dir == Move.DOWN) {
                        throw new CommandParseException(Messages.DIRECTION_ERROR + commandWords[1].toUpperCase() + Messages.LINE_SEPARATOR
                                                            + Messages.ALLOWED_MOVES);
                    }
                    return this;
                } else {
                    throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
                }
            } catch (IndexOutOfBoundsException e) {
                throw new CommandParseException(Messages.COMMAND_PARAMETERS_MISSING);
            } catch (IllegalArgumentException e) {
                throw new CommandParseException(Messages.DIRECTION_ERROR + commandWords[1]);
            }

        } else return null;
    }


    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_MOVE_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_MOVE_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_MOVE_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_MOVE_HELP;
    }
}
