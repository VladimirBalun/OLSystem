package ru.tidstu.testingsystem.authentication;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.services.QuestionsService;
import ru.tidstu.testingsystem.services.UsersService;

@Log4j
public class SignIn {

    public RoleUser authenticate(String login, String password){
        if(isAdmin(login, password)){
            return RoleUser.ADMIN;
        } else if(isUser(login, password)){
            loadQuestionsForUser();
            return RoleUser.USER;
        } else {
            return RoleUser.UNKNOWN;
        }
    }

    private boolean isAdmin(String login, String password){
        if(login.equals("admin") && password.equals("admin")){
            return true;
        } else {
            return false;
        }
    }

    private boolean isUser(String login, String password){
        UsersService usersService = new UsersService();
        if(usersService.setCurrentUser(login, password)){
            return true;
        } else {
            return false;
        }
    }

    private void loadQuestionsForUser(){
        QuestionsService questionsService = new QuestionsService();
        questionsService.setQuestions();
        log.debug("Questions was loaded for user");
    }

}
