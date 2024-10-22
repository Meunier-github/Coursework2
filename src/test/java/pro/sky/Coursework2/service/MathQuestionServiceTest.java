package pro.sky.Coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursework2.exception.MathQuestionException;
import pro.sky.Coursework2.exception.QuestionAlreadyExistsException;
import pro.sky.Coursework2.model.Question;
import pro.sky.Coursework2.repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private MathQuestionService mathQuestionService;
    private final Set<Question> questions = new HashSet<>();
    @Test
    void addMathQuestionExceptionTest() {
        assertThrows(MathQuestionException.class,() -> mathQuestionService.add("",""));
    }
    @Test
    void removeMathQuestionExceptionTest() {
        assertThrows(MathQuestionException.class,() -> mathQuestionService.remove("",""));
    }

    @Test
    void getRandomQuestion() {
        assertNotNull(mathQuestionService.getRandomQuestion());
    }
}