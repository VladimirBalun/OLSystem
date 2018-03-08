package ru.testingsystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.service.UsersService;

@Component
public class AuethentificationImpl implements Auethentification {

    @Autowired
    private UsersService usersService;

    public RoleUser authenticate(String login, String password){
        if(isAdmin(login, password)){
            return RoleUser.ADMIN;
        } else if(isUser(login, password)){
            return RoleUser.USER;
        } else {
            return RoleUser.UNKNOWN;
        }
    }

    private boolean isAdmin(String login, String password){
        return login.equals("admin") && password.equals("admin");
    }

    private boolean isUser(String login, String password){
        return usersService.isValidLoginAndPassword(login, password);
    }

    public boolean register(String login, String password, String name, String group){
        if(usersService.isEmptyLoginForSignUp(login)){
            usersService.addUser(login, password, name, group);
            return true;
        } else {
            return false;
        }
    }

}
