package pl.krokow.ideas.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.krokow.ideas.model.Category;
import pl.krokow.ideas.model.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao {

    private ObjectMapper objectMapper;

    public CategoryDao() {
        this.objectMapper = new ObjectMapper();
    }

    private List<Category> getCategories() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./categories.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Category> findAll() {
        return getCategories();
    }

    public void add(Category category) {
        try {
            List<Category> categories = getCategories();
            categories.add(category);

            Files.writeString(Paths.get("./categories.txt"), objectMapper.writeValueAsString(categories));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Optional<Category> findOne(String categoryName) {
        return getCategories().stream()
                .filter(c -> c.getName().equals(categoryName))
                .findAny();
    }
}
