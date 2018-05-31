package ru.system.OLSystem.daoUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.system.OLSystem.configuration.DataConfig;
import ru.system.OLSystem.data.entity.User;
import ru.system.OLSystem.data.dao.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback
    @Transactional
    public void addingOneUser() {
        User user = new User("name", "login", "password");
        userRepository.saveAndFlush(user);
        boolean isExistUser = userRepository.existsByLoginAndPassword("login", "password");
        Assert.assertTrue( isExistUser);
    }

    @Rollback
    @Transactional
    @Test(expected = DataAccessException.class)
    public void addingUsersWithEqualLogin() {
        User user1 = new User("name_1", "login", "password_1");
        User user2 = new User("name_1", "login", "password_2");
        userRepository.saveAndFlush(user1);
        userRepository.saveAndFlush(user2);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingUser() {
        User user = new User("name", "login", "password");
        userRepository.saveAndFlush(user);
        userRepository.deleteByLogin("login");
        boolean isExistUser = userRepository.existsByLoginAndPassword("login", "password");
        Assert.assertFalse( isExistUser);
    }

}