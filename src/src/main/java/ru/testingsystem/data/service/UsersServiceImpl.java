package ru.testingsystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.Group;
import ru.testingsystem.data.entity.User;
import ru.testingsystem.data.repository.GroupRepository;
import ru.testingsystem.data.repository.UserRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    public boolean isValidDataUser(String login, String password) {
        User user = userRepository.findByLoginAndPassword(login, password);
        return user != null;
    }

    public boolean removeUser(String name) {
        User user = userRepository.findByName(name);
        if(user != null){
            userRepository.deleteByName(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean addUser(String name, String login, String password, String nameGroup) {
        User user = userRepository.findByLogin(login);
        if(user == null){
            Group group = groupRepository.findByName(nameGroup);
            User newUser = User.builder()
                    .login(login)
                    .password(password)
                    .name(name)
                    .countTrueAnswers(0)
                    .countQuestions(0)
                    .group(group)
                    .build();
            userRepository.saveAndFlush(newUser);
            return true;
        } else {
            return false;
        }
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersFromGroup(String nameGroup) {
        Group group = groupRepository.findByName(nameGroup);
        return userRepository.findByGroup(group);
    }

}
