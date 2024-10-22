package pro.sky.Coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Такой вопрос уже есть!")
public class QuestionAlreadyExistsException extends RuntimeException {
}
