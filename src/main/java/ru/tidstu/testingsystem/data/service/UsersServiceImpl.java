package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.UsersDAO;
import ru.tidstu.testingsystem.data.entity.User;

import java.util.List;

@Log4j
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
