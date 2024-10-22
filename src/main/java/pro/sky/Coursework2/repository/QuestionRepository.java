package pro.sky.Coursework2.repository;

import pro.sky.Coursework2.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    void init();

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
