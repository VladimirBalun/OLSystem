package ru.system.OLSystem.controllers.adminRoomTabs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.system.OLSystem.data.entity.ResultUser;
import ru.system.OLSystem.data.service.ResultUsersService;

import java.util.List;

@RestController
public class ResultsController {

    private final static Logger logger = Logger.getLogger(ResultsController.class);

    @Autowired
    private ResultUsersService resultUsersService;

    @RequestMapping(value = "/adminRoom/results/getResults", method = RequestMethod.GET)
    public List<ResultUser> getAllResultsUsers(){
        logger.trace("Request[/adminRoomTabs/results/getResults] for get all the results users.");
        return resultUsersService.getAllResultsUsers();
    }

    @RequestMapping(value = "/adminRoom/results/removeResultUser", method = RequestMethod.DELETE)
    public boolean removeResultUser(@RequestBody ResultUser resultUser){
        logger.trace("Request[/adminRoomTabs/results/removeResultUser] for delete result of user.");
        return true;
    }

}
