package pl.krokow.ideas.handlers;

import pl.krokow.ideas.dao.CategoryDao;
import pl.krokow.ideas.input.UserInputCommand;
import pl.krokow.ideas.model.Category;

import java.util.List;

public class CategoryCommandHandler extends BaseCommandHandler {
    private static final String COMMAND_NAME = "category";
    private CategoryDao categoryDao;

    public CategoryCommandHandler() {
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
                System.out.println("List of categories...");
                List<Category> categories = categoryDao.findAll();
                categories.forEach(System.out::println);
                break;
            case ADD:
                System.out.println("Added category...");
                String categoryName = command.getParam().get(0);
                categoryDao.add(new Category(categoryName));
                break;
            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand()));
            }
        }
    }
}
