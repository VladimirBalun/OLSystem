package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Transactional
    Question findByTitle(String title);

    @Transactional
    void deleteByTitle(String title);

}
