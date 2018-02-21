package ru.tidstu.testingsystem.data.service;

import ru.tidstu.testingsystem.data.entity.Group;

import java.util.List;

public interface GroupsService {

    List<Group> getGroups();

    void addGroup(String nameGroup);

    void changeGroup(String oldName, String newName);

    void deleteGroup(String nameGroup);

}
