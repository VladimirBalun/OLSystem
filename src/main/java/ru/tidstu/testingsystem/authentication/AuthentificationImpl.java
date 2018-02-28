package ru.tidstu.testingsystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tidstu.testingsystem.data.entity.User;
import ru.tidstu.testingsystem.data.service.UsersService;

@Component
public class AuthentificationImpl implements Authentification {

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
        return usersService.setCurrentUser(login, password);
    }

    public boolean register(String login, String password, String name, String group){
        User user = User.builder()
                .login(login)
                .password(password)
                .name(name)
                .group(group)
                .build();
        return isEmptyUser(user);
    }

    private boolean isEmptyUser(User user){
        if(usersService.isEmptyUserForSignUp(user)){
            usersService.addUser(user);
            return true;
        } else {
            return false;
        }
    }
}
