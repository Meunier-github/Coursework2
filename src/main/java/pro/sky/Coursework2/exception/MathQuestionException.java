package pro.sky.Coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED, reason = "Вопросы по математике недоступны!")
public class MathQuestionException extends RuntimeException {
}