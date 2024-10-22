package pro.sky.Coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework2.exception.QuestionAlreadyExistsException;
import pro.sky.Coursework2.exception.QuestionNotFoundException;
import pro.sky.Coursework2.model.Question;
import pro.sky.Coursework2.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service("java")
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;
    private final Random random = new Random();

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {

        Question questionResult = new Question(question, answer);
        if (javaQuestionRepository.getAll().contains(questionResult)) {
            throw new QuestionAlreadyExistsException();
        }
        return javaQuestionRepository.add(questionResult);
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionResult = new Question(question, answer);
        if (!javaQuestionRepository.getAll().contains(questionResult)) {
            throw new QuestionNotFoundException();
        }
        return javaQuestionRepository.remove(questionResult);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = new ArrayList<>(javaQuestionRepository.getAll());
        return questions.get(random.nextInt(questions.size()));
    }
}
