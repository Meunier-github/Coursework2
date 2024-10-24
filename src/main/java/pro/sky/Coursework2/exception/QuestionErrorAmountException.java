package pro.sky.Coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Количество вопросов не должно превышать 5")
public class QuestionErrorAmountException extends RuntimeException {
}
