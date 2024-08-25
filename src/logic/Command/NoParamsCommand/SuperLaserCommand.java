package tp1.logic.Command.NoParamsCommand;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class SuperLaserCommand extends NoParamsCommand {

    @Override
    public boolean execute(GameModel game) throws CommandExecuteException {
        if (game.shootSuperLaser()) {
            game.updateGame();
            return true;
        } else {
            throw new CommandExecuteException(Messages.SUPERLASER_ERROR);
        }
    }


    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_SUPERLASER_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_SUPERLASER_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_SUPERLASER_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_SUPERLASER_HELP;
    }
}
