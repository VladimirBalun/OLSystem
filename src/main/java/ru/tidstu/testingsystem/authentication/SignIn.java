package ru.tidstu.testingsystem.authentication;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.dao.QuestionsDAOImpl;
import ru.tidstu.testingsystem.dao.QuestionsDAOImpl;
import ru.tidstu.testingsystem.dao.UsersDAOImpl;
import ru.tidstu.testingsystem.services.QuestionsService;

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
        UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
        if(usersDAOImpl.setCurrentUser(login, password)){
            return true;
        } else {
            return false;
        }
    }

    private void loadQuestionsForUser(){
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
        QuestionsService questionsService = (QuestionsService) appContext.getBean("questionsService");
        questionsService.setQuestionsForUser();
        log.debug("Questions was loaded for user");
    }

}
