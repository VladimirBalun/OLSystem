package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testingsystem.data.entity.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, String> {

}
