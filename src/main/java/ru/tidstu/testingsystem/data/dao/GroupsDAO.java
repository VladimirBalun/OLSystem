package ru.tidstu.testingsystem.data.dao;
import ru.tidstu.testingsystem.data.entity.Group;

import java.util.List;

public interface GroupsDAO {

    public List<Group> getGroups();

    public void addGroup(String nameGroup);

    public void changeGroup(String oldName, String newName);

    public void deleteGroup(String nameGroup);

}
