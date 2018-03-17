package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.User;

import java.util.List;

public interface UsersService {

    boolean isValidDataUser(String login, String password);

    boolean removeUser(String nameUser);

    boolean addUser(String login, String password, String name, String group);

    List<User> getUsers();

    List<User> getUsersFromGroup(String nameGroup);

}
