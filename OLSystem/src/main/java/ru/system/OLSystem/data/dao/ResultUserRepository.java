package ru.system.OLSystem.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.system.OLSystem.data.entity.ResultUser;
import ru.system.OLSystem.data.entity.User;

public interface ResultUserRepository extends JpaRepository<ResultUser, Long> {

    void deleteByUserAndTime(User user, String time);

}
