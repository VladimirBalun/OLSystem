package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testingsystem.data.domain.TestDataQuestion;

public interface TestDataQuestionRepository extends JpaRepository<TestDataQuestion, Long>{

}
