package ru.tidstu.testingsystem.data.dao;
import ru.tidstu.testingsystem.data.entity.Group;

import java.util.List;

public interface GroupsDAO {

    List<Group> getGroups();

    void addGroup(String nameGroup);

    void changeGroup(String oldName, String newName);

    void deleteGroup(String nameGroup);

}
