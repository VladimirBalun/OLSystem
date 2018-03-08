package ru.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.testingsystem.data.service.BasicDataService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BasicDataService basicDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showMainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", basicDataService.getTitleOfTest());
        modelAndView.addObject("description", basicDataService.getDescriptionOfTest());
        modelAndView.addObject("nameCollege", basicDataService.getNameOfCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumber());
        modelAndView.addObject("addressCollege", basicDataService.getAddress());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
