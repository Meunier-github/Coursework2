package pro.sky.Coursework2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.Coursework2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @Override
    @PostConstruct
    public void init() {
        questions.add(new Question(
                "Генерация случайных чисел",
                "Класс Math библиотеки Java имеет метод random(), который генерирует случайное значение в диапазоне [0,1)"));
        questions.add(new Question(
                "Какие знаете шаблоны проектирования?",
                "Существует множество шаблонов проектирования:Фабричный метод,Одиночка."));
        questions.add(new Question(
                " Какие типы данных в Java?",
                "В Java существует 8 простых типов данных"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }
}
