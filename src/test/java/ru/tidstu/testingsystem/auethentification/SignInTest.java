package ru.tidstu.testingsystem.auethentification;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.tidstu.testingsystem.authentication.RoleUser;
import ru.tidstu.testingsystem.authentication.SignIn;
import ru.tidstu.testingsystem.data.entity.User;
import ru.tidstu.testingsystem.data.service.UsersService;

@Component
public class SignInTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private UsersService usersService = (UsersService) appContext.getBean("usersService");

    private SignIn signIn = new SignIn();

    @Test
    public void authenticateUser(){
        // Gets random user from data base
        User user = usersService.getUsers().get(0);
        if(signIn.authenticate(user.getLogin(), user.getPassword()) == RoleUser.USER){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void notAuthenticateUser(){
        // Gets random user from data base and add incorrect data to login and password
        User user = usersService.getUsers().get(0);
        if(signIn.authenticate(user.getLogin() + "i", user.getPassword() + "v") == RoleUser.UNKNOWN){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

//    @Test
//    public void authenticateAdmin(){
//        if(signIn.authenticate("admin", "admin") == RoleUser.ADMIN){
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertTrue(false);
//        }
//    }

}
