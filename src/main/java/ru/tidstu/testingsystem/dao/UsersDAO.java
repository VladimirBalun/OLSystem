package ru.tidstu.testingsystem.dao;

import ru.tidstu.testingsystem.domain.User;
import java.util.List;

public interface UsersDAO {

    public boolean setCurrentUser(String login, String password);

    public User getCurrentUser();

    public boolean isEmptyUserForSignUp(User user);

    public void delUser(String nameUser);

    public void addUser(User user);

    public List<User> getUsers();

    public List<User> getUsersFromGroup(String nameGroup);

}
