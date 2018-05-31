package ru.system.OLSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.system.OLSystem.authentication.Authentication;
import ru.system.OLSystem.olympiad.Olympiad;

@RestController
class AuthenticationController {

    @Autowired
    private Authentication authentication;

    @Autowired
    private Olympiad olympiad;

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public String authenticateUser(@RequestParam(value = "login") String login,
                                   @RequestParam(value = "password") String password) {
        switch (authentication.authenticate(login, password)) {
            case ADMIN :
                return "ADMIN";
            case PARTICIPANT :
                olympiad.startOlympiad(login);
                return "PARTICIPANT";
            default :
                return "UNKNOWN";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean registerUser(@RequestParam(value = "name") String name,
                                @RequestParam(value = "login") String login,
                                @RequestParam(value = "password") String password) {
        return authentication.register(name, login, password);
    }

}