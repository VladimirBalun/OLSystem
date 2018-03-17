package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.Group;
import ru.testingsystem.data.entity.User;
import ru.testingsystem.data.repository.UserRepository;

import java.util.List;

@Log4j
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    public boolean isValidDataUser(String login, String password) {
        User user = userRepository.findByLoginAndPassword(login, password);
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removeUser(String name) {
        User user = userRepository.findByName(name);
        if(user != null){
            log.debug("User [" + name + "] was deleted.");
            userRepository.deleteByName(name);
            return true;
        } else {
            log.debug("User [" + name + "] wasn't deleted. This is user not found.");
            return false;
        }
    }

    public boolean addUser(String name, String login, String password, String nameGroup) {
        User user = userRepository.findByLogin(login);
        if(user == null){
            User newUser = new User(login, password, name, 0,0, new Group(nameGroup));
            userRepository.saveAndFlush(newUser);
            log.debug("User login=[" + login + "] and name=[" + name + "] was added");
            return true;
        } else {
            log.debug("User login=[" + login + "] wasn't added. This user is exist.");
            return false;
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersFromGroup(String nameGroup) {
        return userRepository.findByGroup(new Group(nameGroup));
    }
}
