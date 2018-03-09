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
        modelAndView.addObject("title", basicDataService.getTitleTestingSystem());
        modelAndView.addObject("description", basicDataService.getDescriptionTestingSystem());
        modelAndView.addObject("nameCollege", basicDataService.getNameCollege());
        modelAndView.addObject("numberCollege", basicDataService.getPhoneNumberCollege());
        modelAndView.addObject("addressCollege", basicDataService.getAddressCollege());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
