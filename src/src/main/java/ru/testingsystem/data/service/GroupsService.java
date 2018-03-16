package ru.testingsystem.data.service;

import ru.testingsystem.data.domain.Group;

import java.util.List;

public interface GroupsService {

    List<Group> getGroups();

    boolean addGroup(String nameGroup);

    boolean changeNameGroup(String oldName, String newName);

    boolean removeGroup(String nameGroup);

}
