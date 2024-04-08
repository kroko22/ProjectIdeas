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
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDao {

    private static Logger LOG = Logger.getLogger(QuestionDao.class.getName());

    private ObjectMapper objectMapper;

    public QuestionDao() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Question> findAll() {
        return getQuestions();
    }

    private List<Question> getQuestions() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./questions.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on getQuestions", e);
            return new ArrayList<>();
        }
    }

    public void add(Question question) {
        try {
            List<Question> questions = getQuestions();
            questions.add(question);

            Files.writeString(Paths.get("./questions.txt"), objectMapper.writeValueAsString(questions));

        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addQuestion", e);
        }
    }
}
