package tp1.logic.Command.NoParamsCommand;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ShootCommand extends NoParamsCommand {

    @Override
    public boolean execute(GameModel game) throws CommandExecuteException {

        if (game.shootLaser()) {
            game.updateGame();
            return true;
        } else {
            throw new CommandExecuteException(Messages.LASER_ERROR);
        }
    }


    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_SHOOT_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_SHOOT_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_SHOOT_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_SHOOT_HELP;
    }
}
