package ru.testingsystem.controllers.admin_room;

import org.springframework.web.bind.annotation.*;
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
        groupsService.deleteGroup(titleGroup);
        return groupsService.getGroups();
    }

    @RequestMapping(value = "/changeGroup", method = RequestMethod.POST)
    public List<Group> changeTitleGroup(@RequestParam(value = "old_title_group") String oldTitleGroup,
                                        @RequestParam(value = "new_title_group") String newTitleGroup){
        groupsService.changeGroup(oldTitleGroup,newTitleGroup);
        return groupsService.getGroups();
    }

}
