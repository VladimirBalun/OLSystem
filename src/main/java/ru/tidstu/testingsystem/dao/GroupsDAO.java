package ru.tidstu.testingsystem.dao;

import ru.tidstu.testingsystem.domain.Group;

import java.util.List;

public interface GroupsDAO {

    public List<Group> getGroups();

    public void addGroup(String nameGroup);

    public void changeGroup(String oldName, String newName);

    public void deleteGroup(String nameGroup);

}
