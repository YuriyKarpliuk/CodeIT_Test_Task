package yuriy.karpliuk.codeit_test_task.service;

import org.springframework.http.ResponseEntity;
import yuriy.karpliuk.codeit_test_task.dto.request.UserRequest;
import yuriy.karpliuk.codeit_test_task.exception.NotValidDateRange;

import java.time.LocalDate;

public interface UserService {
    ResponseEntity<?> updateAllUserFields(Long id, UserRequest userRequest);

    ResponseEntity<?> updateUserFields(Long id, UserRequest userRequest);

    ResponseEntity<?> getUsersByBirthDateRange(LocalDate startDate, LocalDate endDate) throws NotValidDateRange;
}
