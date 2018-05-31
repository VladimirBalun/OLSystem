package ru.system.OLSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.system.OLSystem.data.entity.DataOlympiad;
import ru.system.OLSystem.olympiad.Olympiad;
import ru.system.OLSystem.olympiad.pojo.Participant;
import ru.system.OLSystem.data.service.DataOlympiadService;
import ru.system.OLSystem.olympiad.pojo.Program;

import java.util.List;

@RestController
class OlympiadController {

    @Autowired
    private DataOlympiadService dataOlympiadService;

    @Autowired
    private Olympiad olympiad;

    @RequestMapping(value = "/olympiad/getDataOlympiad", method = RequestMethod.GET)
    public List<DataOlympiad> getInformationAboutOlympiad(){
        return dataOlympiadService.getAllDataOlympiad();
    }

    @RequestMapping(value = "/olympiad/getParticipant", method = RequestMethod.GET)
    public Participant getParticipantOlympiad(){
        return olympiad.getCurrentParticipant();
    }

    @RequestMapping(value = "/olympiad/checkTask", method = RequestMethod.PUT)
    public int checkTaskDuringOlympiad(@RequestBody Program program) {
        return olympiad.checkProgram(program.getNameProgram(), program.getTextProgram());
    }

}