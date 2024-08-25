package tp1.logic.Command.NoParamsCommand;

import tp1.logic.GameModel;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand{

    @Override
    public boolean execute(GameModel game) {
        System.out.println(Messages.HELP);
        System.out.println();
        return false;
    }

    // GETTERS
    @Override
    protected String getName() {
        return Messages.COMMAND_HELP_NAME;
    }

    @Override
    protected String getShortcut() {
        return Messages.COMMAND_HELP_SHORTCUT;
    }

    @Override
    protected String getDetails() {
        return Messages.COMMAND_HELP_DETAILS;
    }

    @Override
    protected String getHelp() {
        return Messages.COMMAND_HELP_HELP;
    }


}
