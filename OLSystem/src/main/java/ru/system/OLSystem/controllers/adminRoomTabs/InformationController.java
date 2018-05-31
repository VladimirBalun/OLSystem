package ru.system.OLSystem.controllers.adminRoomTabs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.system.OLSystem.data.entity.DataOlympiad;
import ru.system.OLSystem.data.service.DataOlympiadService;

import java.util.Arrays;
import java.util.List;

@RestController
public class InformationController {

    private final static Logger logger = Logger.getLogger(InformationController.class);

    @Autowired
    private DataOlympiadService dataOlympiadService;

    @RequestMapping(value = "/adminRoom/information/getDataOlympiad", method = RequestMethod.GET)
    public List<DataOlympiad> getInformationAboutOlympiad(){
        logger.trace("Request[/adminRoomTabs/information/getDataOlympiad] for get information about olympiad");
        return dataOlympiadService.getAllDataOlympiad();
    }

    @RequestMapping(value = "/adminRoom/information/changeDataOlympiad", method = RequestMethod.PUT)
    public boolean changeDataOlympiad(@RequestBody DataOlympiad[] dataOlympiads) {
        logger.trace("Request[/adminRoomTabs/information/changeDataOlympiad] for changing data: \"" + Arrays.toString(dataOlympiads) + "\".");
        return dataOlympiadService.changeDataOlympiad(dataOlympiads);
    }

}
