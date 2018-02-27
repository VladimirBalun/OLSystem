package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.GroupsDAO;
import ru.tidstu.testingsystem.data.entity.Group;

import java.util.List;

@Log4j
@Service
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    private GroupsDAO groupsDAO;

    @Transactional
    public List<Group> getGroups() {
        return groupsDAO.getGroups();
    }

    @Transactional
    public void addGroup(String nameGroup) {
        groupsDAO.addGroup(nameGroup);
        log.debug("Group " + nameGroup + " was added");
    }

    @Transactional
    public void changeGroup(String oldName, String newName) {
        groupsDAO.changeGroup(oldName, newName);
        log.debug("Name of group " + oldName + " was changed on " + oldName);
    }

    @Transactional
    public void deleteGroup(String nameGroup) {
        groupsDAO.deleteGroup(nameGroup);
        log.debug("Group " + nameGroup + " was deleted");
    }

}
