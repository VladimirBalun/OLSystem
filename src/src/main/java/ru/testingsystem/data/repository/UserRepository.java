package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.entity.Group;
import ru.testingsystem.data.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    User findByName(String name);

    @Transactional
    User findByLogin(String login);

    @Transactional
    User findByLoginAndPassword(String login, String password);

    @Transactional
    List<User> findByGroup(Group group);

    @Transactional
    void deleteByName(String name);

}
