package yuriy.karpliuk.codeit_test_task.controller;

import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuriy.karpliuk.codeit_test_task.dto.request.UserRequest;
import yuriy.karpliuk.codeit_test_task.exception.NotValidDateRange;
import yuriy.karpliuk.codeit_test_task.service.UserService;

import java.time.LocalDate;
import java.util.Map;


@RestController
@RequestMapping("/users")
@Data
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAllUserFields(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest) {
        return userService.updateAllUserFields(id, userRequest);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserFields(@PathVariable Long id, @Valid @RequestBody Map<String, Object> fields) {
        return userService.updateUserFields(id, fields);
    }

    @GetMapping
    public ResponseEntity<?> getUsersByBirthDateRange(@RequestParam("start") LocalDate startDate,
                                                      @RequestParam("end") LocalDate endDate) throws NotValidDateRange {
        return userService.getUsersByBirthDateRange(startDate, endDate);
    }
}
