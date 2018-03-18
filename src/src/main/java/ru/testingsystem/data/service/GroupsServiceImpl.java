package ru.testingsystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.Group;
import ru.testingsystem.data.entity.User;
import ru.testingsystem.data.repository.GroupRepository;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public boolean addGroup(String name) {
        Group group = groupRepository.findByName(name);
        if(group == null) {
            groupRepository.saveAndFlush(new Group(name));
            return true;
        } else {
            return false;
        }
    }

    public boolean changeNameGroup(String oldName, String newName) {
        Group oldGroup = groupRepository.findByName(oldName);
        Group newGroup = groupRepository.findByName(newName);
        if(oldGroup != null && newGroup == null){
            oldGroup.setName(newName);
            groupRepository.save(oldGroup);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeGroup(String name) {
        Group group = groupRepository.findByName(name);
        if(group != null) {
            groupRepository.deleteByName(name);
            return true;
        } else {
            return false;
        }
    }

}