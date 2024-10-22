package pro.sky.Coursework2.service;

import pro.sky.Coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
