package ru.testingsystem.controllers.admin_room;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.testingsystem.data.entity.Group;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController extends AdminRoomController{

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public List<Group> addGroup(@RequestParam(value = "title_group") String titleGroup){
        groupsService.addGroup(titleGroup);
        return groupsService.getGroups();
    }

    @RequestMapping(value = "/delGroup", method = RequestMethod.POST)
    public List<Group> removeGroup(@RequestParam(value = "title_group_del") String titleGroup){
        groupsService.removeGroup(titleGroup);
        return groupsService.getGroups();
    }

    @RequestMapping(value = "/changeGroup", method = RequestMethod.POST)
    public List<Group> changeTitleGroup(@RequestParam(value = "old_title_group") String oldTitleGroup,
                                        @RequestParam(value = "new_title_group") String newTitleGroup){
        groupsService.changeNameGroup(oldTitleGroup, newTitleGroup);
        return groupsService.getGroups();
    }

}