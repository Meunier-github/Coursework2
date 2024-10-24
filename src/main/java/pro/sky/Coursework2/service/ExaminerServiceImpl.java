package pro.sky.Coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework2.exception.QuestionErrorAmountException;
import pro.sky.Coursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServiceList;
    public static final int MAX_AMOUNT = 5;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.questionServiceList = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
    }

    private final Random random = new Random();

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (amount > MAX_AMOUNT) {
            throw new QuestionErrorAmountException();
        }

        int javaQuestionAmount = questionServiceList.get(0).getAll().size() < amount
                ? random.nextInt(questionServiceList.get(0).getAll().size())
                : random.nextInt(amount);

        while (questions.size() < javaQuestionAmount) {
            questions.add(questionServiceList.get(0).getRandomQuestion());
        }
        while (questions.size() < amount) {
            questions.add(questionServiceList.get(1).getRandomQuestion());
        }

        return questions;
    }
}
