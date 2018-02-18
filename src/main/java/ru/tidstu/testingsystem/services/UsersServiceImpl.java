package ru.tidstu.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.dao.UsersDAO;
import ru.tidstu.testingsystem.domain.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    public boolean setCurrentUser(String login, String password) {
        return usersDAO.setCurrentUser(login, password);
    }

    public User getCurrentUser() {
        return usersDAO.getCurrentUser();
    }

    public boolean isEmptyUserForSignUp(User user) {
        return usersDAO.isEmptyUserForSignUp(user);
    }

    @Transactional
    public void delUser(String nameUser) {
        usersDAO.delUser(nameUser);
    }

    @Transactional
    public void addUser(User user) {
        usersDAO.addUser(user);
    }

    public List<User> getUsers() {
        return usersDAO.getUsers();
    }

    public List<User> getUsersFromGroup(String nameGroup) {
        return usersDAO.getUsersFromGroup(nameGroup);
    }
}
