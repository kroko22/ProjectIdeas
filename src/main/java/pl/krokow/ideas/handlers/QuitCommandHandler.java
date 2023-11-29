package pl.krokow.ideas.handlers;

import pl.krokow.ideas.QuitIdeasAplicationException;
import pl.krokow.ideas.input.UserInputCommand;

public class QuitCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "quit";

    @Override
    public void handle(UserInputCommand command) {
        throw new QuitIdeasAplicationException();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
