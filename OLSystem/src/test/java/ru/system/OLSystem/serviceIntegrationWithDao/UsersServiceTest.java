package ru.system.OLSystem.serviceIntegrationWithDao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.system.OLSystem.configuration.DataConfig;
import ru.system.OLSystem.data.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    @Rollback
    @Transactional
    public void addingOneUser() {
        boolean isAdding = usersService.addNewUser("name", "login", "password");
        Assert.assertTrue(isAdding);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingOneUser() {
        boolean isAdding = usersService.addNewUser("name", "login", "password");
        Assert.assertTrue(isAdding);
        String[] userLogin = { "login" };
        boolean isDeleting = usersService.removeUsersByLogin(userLogin);
        Assert.assertTrue(isDeleting);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingNonExistentUser() {
        String[] userLogin = { "undefined_login" };
        boolean isDeleting = usersService.removeUsersByLogin(userLogin);
        Assert.assertFalse(isDeleting);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingNonExistentAndExistentUser() {
        boolean isAdding = usersService.addNewUser("name", "login", "password");
        Assert.assertTrue(isAdding);
        String[] usersLogin = { "login", "undefined_login" };
        boolean isDeleting = usersService.removeUsersByLogin(usersLogin);
        Assert.assertFalse(isDeleting);
    }

}