package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.Group;

import java.util.List;

public interface GroupsService {

    List<Group> getGroups();

    boolean addGroup(String name);

    boolean changeNameGroup(String oldName, String newName);

    boolean removeGroup(String name);

}
