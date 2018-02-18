package ru.tidstu.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.dao.GroupsDAO;
import ru.tidstu.testingsystem.domain.Group;

import java.util.List;

public class GroupsServiceImpl implements GroupsService {

    @Autowired
    private GroupsDAO groupsDAO;

    public List<Group> getGroups() {
        return groupsDAO.getGroups();
    }

    @Transactional
    public void addGroup(String nameGroup) {
        groupsDAO.addGroup(nameGroup);
    }

    @Transactional
    public void changeGroup(String oldName, String newName) {
        groupsDAO.changeGroup(oldName, newName);
    }

    @Transactional
    public void deleteGroup(String nameGroup) {
        groupsDAO.deleteGroup(nameGroup);
    }

}
