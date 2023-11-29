package pl.krokow.ideas.handlers;

import pl.krokow.ideas.input.UserInputCommand;

public interface  CommandHandler {
    void handle(UserInputCommand command);
    boolean supports(String name);
}
