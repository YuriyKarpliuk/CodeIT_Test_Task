package yuriy.karpliuk.codeit_test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuriy.karpliuk.codeit_test_task.entity.User;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUsersByBirthDateBetween(LocalDate startDate, LocalDate endDate);
}
