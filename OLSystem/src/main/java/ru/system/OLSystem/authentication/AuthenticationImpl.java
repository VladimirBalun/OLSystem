package ru.system.OLSystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.system.OLSystem.data.service.UsersService;

@Component
public class AuthenticationImpl implements Authentication {

    @Autowired
    private UsersService usersService;

    private final String ADMIN_LOGIN = "admin1";
    private final String ADMIN_PASSWORD = "e00cf25ad42683b3df678c61f42c6bda";

    public UserRole authenticate(String login, String password) {
        if (login.equals(ADMIN_LOGIN) & password.equals(ADMIN_PASSWORD)) {
            return UserRole.ADMIN;
        }
        if (usersService.isExistUser(login, password)) {
            return UserRole.PARTICIPANT;
        } else {
            return UserRole.UNKNOWN;
        }
    }

    public boolean register(String name, String login, String password)  {
        return usersService.addNewUser(name, login, password);
    }

}
