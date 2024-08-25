package tp1.logic.Command.NoParamsCommand;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ShockWaveCommand extends NoParamsCommand {

    @Override
    public boolean execute(GameModel game) throws CommandExecuteException {
        if (game.shockWave()) {
            game.updateGame();
            return true;
        } else {
            throw new CommandExecuteException(Messages.SHOCKWAVE_ERROR);
        }
    }


    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_SHOCKWAVE_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_SHOCKWAVE_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_SHOCKWAVE_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_SHOCKWAVE_HELP;
    }

}
