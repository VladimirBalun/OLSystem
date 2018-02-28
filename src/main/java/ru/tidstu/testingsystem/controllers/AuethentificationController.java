package ru.tidstu.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tidstu.testingsystem.authentication.Authentification;
import ru.tidstu.testingsystem.authentication.RoleUser;
import ru.tidstu.testingsystem.data.service.GroupsService;

@Controller
@RequestMapping("/auethentification")
public class AuethentificationController {

    @Autowired
    private Authentification authentification;
    @Autowired
    private GroupsService groupsService;

    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("groups", groupsService.getGroups());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String logIn(@RequestParam(value = "login_sign_in") String login, @RequestParam(value = "pass_sign_in") String password){
        RoleUser roleUser = authentification.authenticate(login, password);
        switch (roleUser) {
            case ADMIN:
                return "redirect:/adminRoom/showPage";
            case USER:
                return "redirect:/tasks/showPage";
            case UNKNOWN:
                return "Не правильные данные";
        }
        return "Ошибка";
    }

    @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
    public String signUp(@RequestParam(value = "login_sign_up") String login,
                         @RequestParam(value = "pass_sign_up") String password,
                         @RequestParam(value = "name_sign_up") String name,
                         @RequestParam(value = "group_sign_up") String group){
        if(authentification.register(login, password, name, group)){
            return "redirect:/tasks/showPage";
        } else {
            return "Пользователь с таким логином уже зарегистрирован.<br/>Придумайте другой.";
        }
    }

}
