package pro.sky.Coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Такой вопрос не найден!")
public class QuestionNotFoundException extends RuntimeException {
}
