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
        modelAndView.addObject("titleResult", basicDataService.getTitleResultOlympiad());
        modelAndView.addObject("descriptionResult", basicDataService.getDescriptionResultOlympiad());
        modelAndView.addObject("nameCollege", basicDataService.getNameCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumberCollege());
        modelAndView.addObject("addressCollege", basicDataService.getAddressCollege());
        modelAndView.setViewName("end_test");
        return modelAndView;
    }

}
