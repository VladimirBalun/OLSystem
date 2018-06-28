package ru.system.OLSystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.system.OLSystem.data.service.UsersService;

import java.io.IOException;
import java.util.Properties;

@Component
public class AuthenticationImpl implements Authentication {

    @Autowired
    private UsersService usersService;

    private Properties properties;

    public AuthenticationImpl() throws IOException {
        properties = new Properties();
        properties.load(AuthenticationImpl.class.getClassLoader().getResourceAsStream("administrator.properties"));
    }

    public UserRole authenticate(String login, String password) {
        if (login.equals(properties.getProperty("administrator.login")) & password.equals(properties.getProperty("administrator.password"))) {
            return UserRole.ADMIN;
        } else if (usersService.isExistUser(login, password)) {
            return UserRole.PARTICIPANT;
        } else {
            return UserRole.UNKNOWN;
        }
    }

    public boolean register(String name, String login, String password)  {
        return usersService.addNewUser(name, login, password);
    }

}
