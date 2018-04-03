package ru.testingsystem.controllers.adminRoom;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settings")
public class SettingsController extends AdminRoomController {

    @RequestMapping(value = "/changeTime", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String changeTimePassingOlympiad(@RequestParam(value = "new_time") String newTime){
        basicDataService.setTimePassingOlympiad(newTime);
        return "Время проведения олимпиадны успешно изменено на " + newTime;
    }

    @RequestMapping(value = "/changeLanguage", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String changeProgrammingLanguagePassingOlympiad(@RequestParam(value = "new_language") String newLanguage){
        basicDataService.setProgrammingLanguageOlympiad(newLanguage);
        return "Время проведения олимпиадны успешно изменено на " + newLanguage;
    }

}
