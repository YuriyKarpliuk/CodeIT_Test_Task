package yuriy.karpliuk.codeit_test_task.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserResponse {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
}
