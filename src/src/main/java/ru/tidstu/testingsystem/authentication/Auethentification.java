package ru.tidstu.testingsystem.authentication;

import ru.tidstu.testingsystem.data.entity.User;

public interface Auethentification {

    RoleUser authenticate(String login, String password);

    boolean register(String login, String password, String name, String group);

}
