package ru.tidstu.testingsystem.authentication;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.dao.QuestionsDAOImpl;
import ru.tidstu.testingsystem.dao.UsersDAOImpl;
import ru.tidstu.testingsystem.domain.User;
import ru.tidstu.testingsystem.services.QuestionsService;

@Log4j
public class SignUp {

    public boolean register(User user){
        return isEmptyUser(user);
    }

    private boolean isEmptyUser(User user){
        UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
        if(usersDAOImpl.isEmptyUserForSignUp(user)){
            usersDAOImpl.addUser(user);
            loadQuestionsForUser();
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