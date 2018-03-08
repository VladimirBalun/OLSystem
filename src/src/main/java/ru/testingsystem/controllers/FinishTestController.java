package ru.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.testingsystem.data.service.BasicDataService;
import ru.testingsystem.olympiad.Olympiad;


@Controller
public class FinishTestController {

    @Autowired
    private Olympiad olympiad;
    @Autowired
    private BasicDataService basicDataService;

    @RequestMapping(value = "/finishOlympiad", method = RequestMethod.GET)
    public ModelAndView finishOlympiad(){
        olympiad.finishOlympiad();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("titleResult", basicDataService.getTitleOfResult());
        modelAndView.addObject("descriptionResult", basicDataService.getDescriptionOfResult());
        modelAndView.addObject("nameCollege", basicDataService.getNameOfCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumber());
        modelAndView.addObject("addressCollege", basicDataService.getAddress());
        modelAndView.setViewName("end_test");
        return modelAndView;
    }

}
