package ru.tidstu.testingsystem.services;

import ru.tidstu.testingsystem.domain.User;

import java.util.List;

public interface UsersService {

    public boolean setCurrentUser(String login, String password);

    public User getCurrentUser();

    public boolean isEmptyUserForSignUp(User user);

    public void delUser(String nameUser);

    public void addUser(User user);

    public List<User> getUsers();

    public List<User> getUsersFromGroup(String nameGroup);

}
