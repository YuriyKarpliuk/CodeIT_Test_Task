package yuriy.karpliuk.codeit_test_task.dto.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
}
