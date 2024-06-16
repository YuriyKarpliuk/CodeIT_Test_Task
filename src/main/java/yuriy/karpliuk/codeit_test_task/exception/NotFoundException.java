package yuriy.karpliuk.codeit_test_task.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends RuntimeException {
    private static final String NOT_FOUND = " does not found";

    public NotFoundException(String message) {
        super(message + NOT_FOUND);
    }
}
