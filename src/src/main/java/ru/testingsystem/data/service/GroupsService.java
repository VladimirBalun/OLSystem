package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.Group;

import java.util.List;

public interface GroupsService {

    List<Group> getGroups();

    void addGroup(String nameGroup);

    void changeGroup(String oldName, String newName);

    void deleteGroup(String nameGroup);

}
