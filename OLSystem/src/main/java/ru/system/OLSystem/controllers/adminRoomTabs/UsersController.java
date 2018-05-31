package ru.system.OLSystem.controllers.adminRoomTabs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.system.OLSystem.data.entity.User;
import ru.system.OLSystem.data.service.UsersService;

import java.util.Arrays;
import java.util.List;

@RestController
public class UsersController {

    private final static Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/adminRoom/users/getUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        logger.trace("Request[/adminRoomTabs/users/getUsers] for get all the users.");
        return usersService.getAllUsers();
    }

    @RequestMapping(value = "/adminRoom/users/removeUsers", method = RequestMethod.DELETE)
    public boolean removeUsers(@RequestParam(value = "logins[]") String[] logins) {
        logger.trace("Request[/adminRoomTabs/users/removeUsers] for deleting user: \"" + Arrays.toString(logins) + "\".");
        return usersService.removeUsersByLogin(logins);
    }

}
