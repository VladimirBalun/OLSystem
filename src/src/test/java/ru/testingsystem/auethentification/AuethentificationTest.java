package ru.testingsystem.auethentification;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.testingsystem.authentication.Auethentification;
import ru.testingsystem.authentication.RoleUser;
import ru.testingsystem.data.entity.User;
import ru.testingsystem.data.service.UsersService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context.xml")
public class AuethentificationTest {

    @Autowired
    private Auethentification auethentification;
    @Autowired
    private UsersService usersService;

    @Test
    public void authenticateUser(){
        // Gets random user from data base
        User user = usersService.getUsers().get(0);
        if(auethentification.authenticate(user.getLogin(), user.getPassword()) == RoleUser.USER){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void notAuthenticateUserWithIncorrectLogin(){
        // Gets random user from data base and add incorrect data to login
        User user = usersService.getUsers().get(0);
        if(auethentification.authenticate(user.getLogin() + "iii", user.getPassword()) == RoleUser.UNKNOWN){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void notAuthenticateUserWithIncorrectPassword(){
        // Gets random user from data base and add incorrect data to password
        User user = usersService.getUsers().get(0);
        if(auethentification.authenticate(user.getLogin(), user.getPassword() + "iii") == RoleUser.UNKNOWN){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void notAuthenticateUserWithIncorrectLoginAndPassword(){
        // Gets random user from data base and add incorrect data to login and password
        User user = usersService.getUsers().get(0);
        if(auethentification.authenticate(user.getLogin() + "iii", user.getPassword() + "iii") == RoleUser.UNKNOWN){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void authenticateAdmin(){
        if(auethentification.authenticate("admin", "admin") == RoleUser.ADMIN){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

}
