package ru.system.OLSystem.controllers.adminRoomTabs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.system.OLSystem.data.entity.ProgLanguage;
import ru.system.OLSystem.data.entity.SettingsOlympiad;
import ru.system.OLSystem.data.service.ProgLanguagesService;
import ru.system.OLSystem.data.service.SettingsOlympiadService;

import java.util.List;

@RestController
public class SettingsController {

    private final static Logger logger = Logger.getLogger(SettingsController.class);

    @Autowired
    private SettingsOlympiadService settingsOlympiadService;

    @Autowired
    private ProgLanguagesService progLanguagesService;

    @RequestMapping(value = "/adminRoom/settings/getProgrammingLanguages", method = RequestMethod.GET)
    public List<ProgLanguage> getAllPossibleLanguagesForOlympiad() {
        logger.trace("Request[/adminRoom/settings/getProgrammingLanguages] for get all possible programing languages.");
        return progLanguagesService.getAllProgrammingLanguages();
    }

    @RequestMapping(value = "/adminRoom/settings/getSettingsOlympiad", method = RequestMethod.GET)
    public List<SettingsOlympiad> getAllSettingsOlympiad() {
        logger.trace("Request[/adminRoomTabs/settings/getSettingsOlympiad] for get all the settings of olympiad.");
        return settingsOlympiadService.getAllSettings();
    }

    @RequestMapping(value = "/adminRoom/settings/changeSettingsOlympiad", method = RequestMethod.PUT)
    public boolean changeTimeOlympiad(@RequestBody SettingsOlympiad settingsOlympiad) {
        logger.trace("Request[adminRoomTabs/settings/changeSettingsOlympiad] for changing: \"timeOlympiad\".");
        return settingsOlympiadService.changeSettingOlympiad(settingsOlympiad);
    }

}