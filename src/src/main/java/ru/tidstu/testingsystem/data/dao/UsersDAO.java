package ru.tidstu.testingsystem.data.dao;

import ru.tidstu.testingsystem.data.entity.User;
import java.util.List;

public interface UsersDAO {

    boolean isValidLoginAndPassword(String login, String password);

    boolean isEmptyLoginForSignUp(String login);

    void delUser(String nameUser);

    void addUser(User user);

    List<User> getUsers();

    List<User> getUsersFromGroup(String nameGroup);

}
