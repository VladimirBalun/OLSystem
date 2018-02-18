package ru.tidstu.testingsystem.services;

import ru.tidstu.testingsystem.domain.Group;

import java.util.List;

public interface GroupsService {

    public List<Group> getGroups();

    public void addGroup(String nameGroup);

    public void changeGroup(String oldName, String newName);

    public void deleteGroup(String nameGroup);

}
