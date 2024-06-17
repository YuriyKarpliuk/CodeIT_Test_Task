package yuriy.karpliuk.codeit_test_task.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import yuriy.karpliuk.codeit_test_task.dto.request.UserRequest;
import yuriy.karpliuk.codeit_test_task.dto.response.MessageResponse;
import yuriy.karpliuk.codeit_test_task.dto.response.UserResponse;
import yuriy.karpliuk.codeit_test_task.entity.User;
import yuriy.karpliuk.codeit_test_task.exception.NotFoundException;
import yuriy.karpliuk.codeit_test_task.exception.NotValidDateRange;
import yuriy.karpliuk.codeit_test_task.repository.UserRepository;
import yuriy.karpliuk.codeit_test_task.service.UserService;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;

@Service
@Data
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public ResponseEntity<?> updateAllUserFields(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User not found for this id: %s", id)));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setBirthDate(userRequest.getBirthDate());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse(String.format("User with id: %s updated successfully!", id)));
    }

    @Override
    public ResponseEntity<?> updateUserFields(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User not found for this id: %s", id)));
        if (userRequest.getFirstName() != null) {
            user.setFirstName(userRequest.getFirstName());
        }
        if (userRequest.getLastName() != null) {
            user.setLastName(userRequest.getLastName());
        }
        if (userRequest.getPhoneNumber() != null) {
            user.setPhoneNumber(userRequest.getPhoneNumber());
        }
        if (userRequest.getBirthDate() != null) {
            user.setBirthDate(userRequest.getBirthDate());
        }

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse(String.format("User with id: %s updated successfully!", id)));
    }

    @Override
    public ResponseEntity<?> getUsersByBirthDateRange(LocalDate startDate, LocalDate endDate) throws NotValidDateRange {
        if (startDate.isAfter(endDate)) {
            throw new NotValidDateRange();
        }

        List<UserResponse> userResponses = userRepository.getUsersByBirthDateBetween(startDate, endDate).stream().map(u -> UserResponse.builder().firstName(u.getFirstName()).lastName(u.getLastName()).birthDate(u.getBirthDate()).phoneNumber(u.getPhoneNumber()).build()).collect(Collectors.toList());

        return ResponseEntity.ok(userResponses);
    }
}
