package ru.tidstu.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.tidstu.testingsystem.data.service.*;
import ru.tidstu.testingsystem.utils.SortingResults;

@Controller
@RequestMapping("/adminRoom")
public class AdminRoomController {

    @Autowired
    private BasicDataService basicDataService;
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private GroupsService groupsService;
    @Autowired
    private ResultsService resultsService;

    @RequestMapping("/showPage")
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("title", basicDataService.getTitleOfTest());
        modelAndView.addObject("description", basicDataService.getDescriptionOfTest());
        modelAndView.addObject("nameCollege", basicDataService.getNameOfCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumber());
        modelAndView.addObject("addressCollege", basicDataService.getAddress());
        modelAndView.addObject("titleResult", basicDataService.getTitleOfResult());
        modelAndView.addObject("descriptionResult", basicDataService.getDescriptionOfResult());

        modelAndView.addObject("questions", questionsService.getQuestions());
        modelAndView.addObject("users", usersService.getUsers());
        modelAndView.addObject("groups",groupsService.getGroups());
        modelAndView.addObject("resultsOfTest", resultsService.getResultsOfUsers(SortingResults.DATE));

        modelAndView.setViewName("admin_room");
        return modelAndView;
    }

}
