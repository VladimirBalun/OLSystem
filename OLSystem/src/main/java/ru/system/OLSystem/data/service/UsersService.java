package ru.system.OLSystem.data.service;

import ru.system.OLSystem.data.entity.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    boolean isExistUser(String login, String password);

    boolean removeUsersByLogin(String[] listLogin);

    boolean addNewUser(String name, String login, String password);

}
