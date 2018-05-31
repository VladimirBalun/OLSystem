package ru.system.OLSystem.data.service;

import ru.system.OLSystem.data.entity.ResultUser;

import java.util.List;

public interface ResultUsersService {

    List<ResultUser> getAllResultsUsers();

    boolean addNewResultUser(String userLogin, String time, String result);

    boolean removeResultByLoginUserAndTime(String userLogin, String time);

}
