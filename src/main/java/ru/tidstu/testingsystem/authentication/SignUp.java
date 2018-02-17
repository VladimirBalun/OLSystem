package ru.tidstu.testingsystem.authentication;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.services.QuestionsService;
import ru.tidstu.testingsystem.services.UsersService;
import ru.tidstu.testingsystem.services.models.User;

@Log4j
public class SignUp {

    public boolean register(User user){
        return isEmptyUser(user);
    }

    private boolean isEmptyUser(User user){
        UsersService usersService = new UsersService();
        if(usersService.isEmptyUserForSignUp(user)){
            usersService.addUser(user);
            loadQuestionsForUser();
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