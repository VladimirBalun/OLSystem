package ru.tidstu.testingsystem.authentication;

import ru.tidstu.testingsystem.data.entity.User;

public interface Authentification {

    RoleUser authenticate(String login, String password);

    boolean register(String login, String password, String name, String group);

}
