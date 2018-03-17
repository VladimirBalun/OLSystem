package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testingsystem.data.entity.TestDataQuestion;

public interface TestDataQuestionRepository extends JpaRepository<TestDataQuestion, Long>{

}
