package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testingsystem.data.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByTitle(String title);

}
