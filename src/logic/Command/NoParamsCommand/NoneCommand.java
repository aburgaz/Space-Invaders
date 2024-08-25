package tp1.logic.Command.NoParamsCommand;

import tp1.logic.GameModel;
import tp1.view.Messages;

public class NoneCommand extends NoParamsCommand {

    @Override
    public boolean execute(GameModel game) {
        game.updateGame();
        return true;
    }


    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_NONE_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_NONE_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_NONE_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_NONE_HELP;
    }

    @Override
    protected boolean matchCommandName(String name) {
        return getName().equalsIgnoreCase(name) || name.equalsIgnoreCase(getShortcut()) || name.equalsIgnoreCase("");
    }
}
