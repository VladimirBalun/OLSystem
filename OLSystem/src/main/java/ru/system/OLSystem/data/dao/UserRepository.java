package ru.system.OLSystem.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.system.OLSystem.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLogin(String login);

    boolean existsByLoginAndPassword(String login, String password);

    void deleteByLogin(String login);

}
