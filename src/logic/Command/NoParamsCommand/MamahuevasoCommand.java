package tp1.logic.Command.NoParamsCommand;

import tp1.logic.GameModel;
import tp1.view.Messages;

public class MamahuevasoCommand extends NoParamsCommand {

    @Override
    public boolean execute(GameModel game) {
        game.cheatCode();
        game.updateGame();
        return true;
    }

    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_CHEATCODE_NAME;
    }

    @Override
    protected String getShortcut() {
        return null;
    }

    @Override
    protected String getDetails() {
        return null;
    }

    @Override
    protected String getHelp() {
        return null;
    }

    @Override
    protected boolean matchCommandName(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
