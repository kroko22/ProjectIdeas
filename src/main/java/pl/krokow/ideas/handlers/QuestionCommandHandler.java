package pl.krokow.ideas.handlers;

import pl.krokow.ideas.dao.CategoryDao;
import pl.krokow.ideas.dao.QuestionDao;
import pl.krokow.ideas.input.UserInputCommand;
import pl.krokow.ideas.model.Category;
import pl.krokow.ideas.model.Question;

import java.util.List;

public class QuestionCommandHandler extends BaseCommandHandler {
    private static final String COMMAND_NAME = "question";

    private QuestionDao questionDao;
    private CategoryDao categoryDao;

    public QuestionCommandHandler() {
        questionDao = new QuestionDao();
        categoryDao = new CategoryDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {

        switch (command.getAction()) {
            case LIST:
                System.out.println("List of questions...");
                List<Question> questions = questionDao.findAll();
                questions.forEach(System.out::println);
                break;
            case ADD:
                System.out.println("Added question...");
                // TODO validate params
                String categoryName = command.getParam().get(0);
                String questionName = command.getParam().get(1);
                Category category = categoryDao.findOne(categoryName)
                        .orElseThrow(() -> new IllegalArgumentException("Category not found: " + categoryName));

                questionDao.add(new Question(questionName, category));
                break;

            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand()));
            }
        }
    }
}
