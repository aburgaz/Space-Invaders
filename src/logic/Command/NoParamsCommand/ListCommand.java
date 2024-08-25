package tp1.logic.Command.NoParamsCommand;

import tp1.logic.GameModel;
import tp1.view.Messages;

public class ListCommand extends NoParamsCommand{

    @Override
    public boolean execute(GameModel game) {
        game.showList();
        return false;
    }

    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_LIST_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_LIST_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_LIST_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_LIST_HELP;
    }
}
