package ru.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.testingsystem.authentication.RoleUser;
import ru.testingsystem.authentication.Auethentification;
import ru.testingsystem.data.service.GroupsService;
import ru.testingsystem.olympiad.Olympiad;

@Controller
@RequestMapping("/auethentification")
public class AuethentificationController {

    @Autowired
    private Auethentification auethentification;
    @Autowired
    private GroupsService groupsService;
    @Autowired
    private Olympiad olympiad;

    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("groups", groupsService.getGroups());
        modelAndView.setViewName("auethentification");
        return modelAndView;
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String logIn(@RequestParam(value = "login_sign_in") String login,
                                      @RequestParam(value = "pass_sign_in") String password) {
        // Redirect is processing with JS(auethentification.js)
        RoleUser roleUser = auethentification.authenticate(login, password);
        switch (roleUser) {
            case ADMIN:
                return "admin_room";
            case USER:
                olympiad.startOlympiad(login, password);
                return "tasks";
            case UNKNOWN:
                return "Не правильные данные";
        }
        return "Не правильные данные";
    }


    @RequestMapping(value = "/SignUp", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String signUp(@RequestParam(value = "login_sign_up") String login,
                         @RequestParam(value = "pass_sign_up") String password,
                         @RequestParam(value = "name_sign_up") String name,
                         @RequestParam(value = "group_sign_up") String nameGroup) {
        // Redirect is processing with JS(auethentification.js)
        if(auethentification.register(login, password, name, nameGroup)){
            olympiad.startOlympiad(login, password);
            System.out.println("controller");
            return "tasks";
        } else {
            return "Пользователь с таким логином уже зарегистрирован";
        }
    }

}
