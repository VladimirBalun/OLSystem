package ru.tidstu.testingsystem.data.service;

import ru.tidstu.testingsystem.data.entity.User;

import java.util.List;

public interface UsersService {

    boolean isValidLoginAndPassword(String login, String password);

    boolean isEmptyLoginForSignUp(String login);

    void delUser(String nameUser);

    void addUser(String login, String password, String name, String group);

    List<User> getUsers();

    List<User> getUsersFromGroup(String nameGroup);

}
