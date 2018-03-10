package ru.testingsystem.controllers.admin_room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.testingsystem.data.dao.SortingResults;
import ru.testingsystem.data.service.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/adminRoom")
public class AdminRoomController {

    @Autowired
    protected BasicDataService basicDataService;
    @Autowired
    protected QuestionsService questionsService;
    @Autowired
    protected UsersService usersService;
    @Autowired
    protected GroupsService groupsService;
    @Autowired
    protected ResultsService resultsService;
    @Autowired
    protected TestDataService testDataService;

    @Autowired
    private Map<String, String> programminLanguages;

    @RequestMapping("/showPage")
    public ModelAndView showPage() throws IOException {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("title", basicDataService.getTitleTestingSystem());
        modelAndView.addObject("description", basicDataService.getDescriptionTestingSystem());
        modelAndView.addObject("nameCollege", basicDataService.getNameCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumberCollege());
        modelAndView.addObject("addressCollege", basicDataService.getAddressCollege());
        modelAndView.addObject("titleResult", basicDataService.getTitleResultOlympiad());
        modelAndView.addObject("descriptionResult", basicDataService.getDescriptionResultOlympiad());
        modelAndView.addObject("programmingLanguage", basicDataService.getProgrammingLanguageOlympiad());

        modelAndView.addObject("questions", questionsService.getQuestions());
        modelAndView.addObject("users", usersService.getUsers());
        modelAndView.addObject("groups",groupsService.getGroups());
        modelAndView.addObject("resultsTest", resultsService.getResultsOfUsers(SortingResults.DATE));
        modelAndView.addObject("programmingLanguages", programminLanguages);


        modelAndView.setViewName("admin_room");
        return modelAndView;
    }

}
