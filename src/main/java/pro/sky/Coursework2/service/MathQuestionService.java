package pro.sky.Coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework2.exception.MathQuestionException;
import pro.sky.Coursework2.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service("math")
public class MathQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        throw new MathQuestionException();
    }

    @Override
    public Question remove(String question, String answer) {
        throw new MathQuestionException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MathQuestionException();
    }

    @Override
    public Question getRandomQuestion() {
        char operator[] = {'+', '-', '/', '*'};
        final int MAX_RANDOM_DIGIT = 100;
        String question = new Random().nextInt(MAX_RANDOM_DIGIT)
                + " "
                + operator[new Random().nextInt(operator.length)]
                + " "
                + new Random().nextInt(MAX_RANDOM_DIGIT)
                + " = ";
        return new Question(question, "");
    }
}
