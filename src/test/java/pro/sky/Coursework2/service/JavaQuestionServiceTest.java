package pro.sky.Coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursework2.exception.QuestionAlreadyExistsException;
import pro.sky.Coursework2.model.Question;
import pro.sky.Coursework2.repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService javaQuestionService;
    private final Set<Question> questions = new HashSet<>();

    @BeforeEach
    void init() {
        questions.add(new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)"));
    }

    @Test
    void addTest() {
        Question question = new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)");
        when(javaQuestionRepository.add(question)).thenReturn(question);
        Question result = javaQuestionService.add("Генерация случайных чисел", "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)");
        assertEquals(question, result);
    }

    @Test
    void removeTest() {
        Question question = new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)");
        when(javaQuestionRepository.getAll())
                .thenReturn(questions);
        when(javaQuestionRepository.remove(question)).thenReturn(question);
        Question result = javaQuestionService.remove("Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)");
        assertEquals(question, result);
    }

    @Test
    void addQuestionAlreadyExistsExceptionTest() {
        when(javaQuestionRepository.getAll())
                .thenReturn(questions);
        assertThrows(QuestionAlreadyExistsException.class,
                () -> javaQuestionService.add("Генерация случайных чисел",
                        "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)"));
    }


    void removeQuestionAlreadyExistsExceptionTest() {
        when(javaQuestionRepository.getAll())
                .thenReturn(questions);
        assertThrows(QuestionAlreadyExistsException.class,
                () -> javaQuestionService.remove("Генерация случайных чисел",
                        "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)"));
    }

    @Test
    void getAll() {
        Question question = new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)");

        when(javaQuestionRepository.getAll())
                .thenReturn(questions);

        assertEquals(questions, javaQuestionService.getAll());

    }
    @Test
    void getRandomQuestion() {
        when(javaQuestionRepository.getAll())
                .thenReturn(questions);
        assertNotNull(javaQuestionService.getRandomQuestion());
    }

}