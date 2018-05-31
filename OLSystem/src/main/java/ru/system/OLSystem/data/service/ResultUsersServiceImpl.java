package ru.system.OLSystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.system.OLSystem.data.dao.UserRepository;
import ru.system.OLSystem.data.entity.ResultUser;
import ru.system.OLSystem.data.dao.ResultUserRepository;

import java.util.List;

@Service
public class ResultUsersServiceImpl implements ResultUsersService {

    @Autowired
    private ResultUserRepository resultUserRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ResultUser> getAllResultsUsers() {
        return resultUserRepository.findAll();
    }

    public boolean addNewResultUser(String userLogin, String time, String result) {
        return false;
    }

    public boolean removeResultByLoginUserAndTime(String userLogin, String time) {
        return false;
    }

}
