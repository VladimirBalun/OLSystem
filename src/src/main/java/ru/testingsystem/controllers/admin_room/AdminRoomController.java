package ru.testingsystem.controllers.admin_room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.testingsystem.data.dao.SortingResults;
import ru.testingsystem.data.service.*;

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

    @RequestMapping("/showPage")
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("title", basicDataService.getTitleTestingSystem());
        modelAndView.addObject("description", basicDataService.getDescriptionTestingSystem());
        modelAndView.addObject("nameCollege", basicDataService.getNameCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumberCollege());
        modelAndView.addObject("addressCollege", basicDataService.getAddressCollege());
        modelAndView.addObject("titleResult", basicDataService.getTitleResultOlympiad());
        modelAndView.addObject("descriptionResult", basicDataService.getDescriptionResultOlympiad());

        modelAndView.addObject("questions", questionsService.getQuestions());
        modelAndView.addObject("users", usersService.getUsers());
        modelAndView.addObject("groups",groupsService.getGroups());
        modelAndView.addObject("resultsTest", resultsService.getResultsOfUsers(SortingResults.DATE));

        modelAndView.setViewName("admin_room");
        return modelAndView;
    }

}
