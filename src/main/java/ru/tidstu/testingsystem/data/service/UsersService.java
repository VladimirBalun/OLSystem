package ru.tidstu.testingsystem.data.service;

import org.springframework.stereotype.Service;
import ru.tidstu.testingsystem.data.entity.User;

import java.util.List;

public interface UsersService {

    boolean setCurrentUser(String login, String password);

    boolean isEmptyUserForSignUp(User user);

    void delUser(String nameUser);

    void addUser(User user);

    List<User> getUsers();

    List<User> getUsersFromGroup(String nameGroup);

}
