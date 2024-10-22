package pro.sky.Coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import pro.sky.Coursework2.exception.QuestionAlreadyExistsException;
import pro.sky.Coursework2.exception.QuestionErrorAmountException;
import pro.sky.Coursework2.model.Question;
import pro.sky.Coursework2.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    private final Set<Question> questions = new HashSet<>();


    @BeforeEach
    void init() {
        questions.add(new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)"));
        questions.add(new Question(
                "5 + 5 = ",
                ""));
    }

    @Test
    void QuestionErrorAmountExceptionTest() {
        assertThrows(QuestionErrorAmountException.class,
                () -> examinerService.getQuestions(ExaminerServiceImpl.MAX_AMOUNT + 1));
    }

    @Test
    void getQuestionsTest() {
        Question javaQuestion = new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)");
        Question mathQuestion = new Question(
                "5 + 5 = ",
                "");
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(mathQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(javaQuestion);
        when(mathQuestionService.getRandomQuestion()).thenReturn(mathQuestion);
        assertEquals(1, examinerService.getQuestions(1).size());
    }

}