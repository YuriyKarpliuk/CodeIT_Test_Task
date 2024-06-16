package yuriy.karpliuk.codeit_test_task.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import yuriy.karpliuk.codeit_test_task.exception.NotFoundException;
import yuriy.karpliuk.codeit_test_task.dto.response.ErrorResponse;
import yuriy.karpliuk.codeit_test_task.exception.NotValidDateRange;


import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException notFoundException) {
        return ErrorResponse.builder()
                .message(notFoundException.getMessage())
                .status(NOT_FOUND.value())
                .timestamp(now())
                .build();
    }

    @ExceptionHandler(NotValidDateRange.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleNotValidDateRangeException(NotValidDateRange notValidDateRange) {
        return ErrorResponse.builder()
                .message(notValidDateRange.getMessage())
                .status(BAD_REQUEST.value())
                .timestamp(now())
                .build();
    }


}
