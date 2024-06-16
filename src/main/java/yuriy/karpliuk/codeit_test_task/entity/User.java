package yuriy.karpliuk.codeit_test_task.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends IdHolder {
    @NotNull(message = "First name is required")
    private String firstName;
    @NotNull(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be earlier than current date")
    private LocalDate birthDate;
    private String phoneNumber;
}
