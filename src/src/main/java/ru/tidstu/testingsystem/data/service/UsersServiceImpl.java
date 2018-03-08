package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.UsersDAO;
import ru.tidstu.testingsystem.data.entity.User;

import java.util.List;

@Log4j
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    public boolean isValidLoginAndPassword(String login, String password) {
        return usersDAO.isValidLoginAndPassword(login, password);
    }

    public boolean isEmptyLoginForSignUp(String login) {
        return usersDAO.isEmptyLoginForSignUp(login);
    }

    @Transactional
    public void delUser(String nameUser) {
        usersDAO.delUser(nameUser);
        log.debug("User " + nameUser + " was deleted");
    }

    @Transactional
    public void addUser(String login, String password, String name, String group) {
        User user = User.builder()
                .login(login)
                .password(password)
                .name(name)
                .group(group)
                .build();
        usersDAO.addUser(user);
        log.debug("User " + login + " : " + name + " was added");
    }

    @Transactional
    public List<User> getUsers() {
        return usersDAO.getUsers();
    }

    @Transactional
    public List<User> getUsersFromGroup(String nameGroup) {
        return usersDAO.getUsersFromGroup(nameGroup);
    }
}
