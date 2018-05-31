package ru.system.OLSystem.data.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import ru.system.OLSystem.data.entity.User;
import ru.system.OLSystem.data.dao.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final static Logger logger = Logger.getLogger(UsersServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isExistUser(String login, String password) {
        return userRepository.existsByLoginAndPassword(login, password);
    }

    @Transactional
    public boolean removeUsersByLogin(String[] listLogin) {
        try {
            for (String login : listLogin) {
                if(!userRepository.existsByLogin(login)){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
                userRepository.deleteByLogin(login);
                logger.debug("User \"" + login + "\" was successfully deleted.");
            }
            return true;
        } catch (DataAccessException e) {
            logger.debug("User \"" + Arrays.toString(listLogin) + "\" wasn't deleted. Cause: " + e.getCause());
            return false;
        }
    }

    public boolean addNewUser(String name, String login, String password) {
        try {
            User user = new User(name, login, password);
            userRepository.saveAndFlush(user);
            logger.debug("User \"" + login + "\" was successfully  added.");
            return true;
        } catch (DataAccessException e) {
            logger.debug("User \"" + login + "\" wasn't added. Cause: " + e.getCause());
            return false;
        }
    }

}
