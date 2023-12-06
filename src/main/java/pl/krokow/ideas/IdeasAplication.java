package pl.krokow.ideas;

import pl.krokow.ideas.handlers.CategoryCommandHandler;
import pl.krokow.ideas.handlers.CommandHandler;
import pl.krokow.ideas.handlers.HelpCommandHandler;
import pl.krokow.ideas.handlers.QuitCommandHandler;
import pl.krokow.ideas.input.UserInputCommand;
import pl.krokow.ideas.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdeasAplication {
    public static void main(String[] args) {
        new IdeasAplication().start();
    }

    private void start() {
        System.out.println("Start app...");

        /**
         * category list -> categoryList()
         * category add CategoryName -> categoryAdd(name)
         *
         * quit -> quitAplication()
         *
         * question list -> questionList()
         * question add CategoryName QuestionName ->questionAdd(CategoryName, QuestionName)
         *
         * answer list QuestionName -> answerList(QuestionName)
         * answer add AnswerName QuestionName -> answerAdd(QuestionName, AnswerName)
         *
         */

        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        List<CommandHandler> handlers = new ArrayList<CommandHandler>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuitCommandHandler());
        handlers.add(new CategoryCommandHandler());


        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);
            } catch (QuitIdeasApplicationException e) {
                System.out.println("Quit...");
                applicationLoop = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}