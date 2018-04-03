package ru.testingsystem.controllers.adminRoom;

import org.springframework.web.bind.annotation.*;
import ru.testingsystem.data.entity.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController extends AdminRoomController {

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public List<User> removerUser(@RequestParam(value = "name_user_for_del") String nameUser){
        usersService.removeUser(nameUser);
        return usersService.getUsers();
    }

    @RequestMapping(value = "/selectUsersFromGroup", method = RequestMethod.POST)
    public List<User> selectUsersFromGroup(@RequestParam(value = "group_for_select_users") String nameGroup){
        return usersService.getUsersFromGroup(nameGroup);
    }

}
