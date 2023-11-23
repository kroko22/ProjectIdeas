package pl.krokow.ideas;

import pl.krokow.ideas.input.UserInputCommand;
import pl.krokow.ideas.input.UserInputManager;

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

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}