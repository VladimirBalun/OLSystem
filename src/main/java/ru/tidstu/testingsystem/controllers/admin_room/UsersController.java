package ru.tidstu.testingsystem.controllers.admin_room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tidstu.testingsystem.data.entity.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController extends AdminRoomController {

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public @ResponseBody List<User> removerUser(@RequestParam(value = "name_user_for_del") String nameUser){
        usersService.delUser(nameUser);
        return usersService.getUsers();
    }

    @RequestMapping(value = "/selectUsersFromGroup", method = RequestMethod.POST)
    public @ResponseBody List<User> selectUsersFromGroup(@RequestParam(value = "group_for_select_users") String nameGroup){
        return usersService.getUsersFromGroup(nameGroup);
    }

}
