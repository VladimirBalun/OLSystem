package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.entity.BasicData;

public interface BasicDataRepository extends JpaRepository<BasicData, Long> {

    @Transactional
    BasicData findByName(String name);

}
