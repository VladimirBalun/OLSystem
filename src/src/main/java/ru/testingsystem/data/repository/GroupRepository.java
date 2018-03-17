package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Transactional
    void deleteByName(String name);

    @Transactional
    Group findByName(String name);

}
