package yuriy.karpliuk.codeit_test_task.exception;

public class NotValidDateRange extends Exception {
    public NotValidDateRange() {
        super("Start date must be less than end date");
    }
}
