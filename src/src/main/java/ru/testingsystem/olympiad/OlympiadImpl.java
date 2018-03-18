package ru.testingsystem.olympiad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.Log;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.data.entity.User;
import ru.testingsystem.data.service.QuestionsService;
import ru.testingsystem.data.service.UsersService;

import java.util.*;

@Component
public class OlympiadImpl implements Olympiad {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CheckingProgram checkingProgram;

    private User currentUser;

    public void startOlympiad(String login, String password){
        currentUser = usersService.getUserByLoginAndPassword(login, password);
        currentUser.setQuestionsUser(questionsService.getQuestions());
    }

    public String getStatisticUser() {
       return String.valueOf(currentUser.getCountTrueAnswers() + "/" + currentUser.getCountQuestions());
    }

    public List<Question> getQuestions() {
        return currentUser.getQuestionsUser();
    }

    public Question getQuestion(String title){
        for (Question question : currentUser.getQuestionsUser()) {
            if(question.getTitle().equals(title)){
                return question;
            }
        }
        return currentUser.getQuestionsUser().get(0);
    }

    public Queue<Log> getLogsOfRunningTest(){
        return currentUser.getLogsUser();
    }

    public ResultRunningProgram checkTask(String nameQuestion, String textProgram){
        switch (checkingProgram.checkTask(nameQuestion, textProgram)){
            case ERROR_COMPILATION:
                currentUser.addLog(new Log("Ошибка компиляции в задании " + nameQuestion, getCurrentTime()));
                return ResultRunningProgram.ERROR_COMPILATION;
            case LOGIC_ERROR_IN_PROGRAM:
                currentUser.addLog(new Log("Ошибка в тестах для задания " + nameQuestion, getCurrentTime()));
                return ResultRunningProgram.LOGIC_ERROR_IN_PROGRAM;
            case SUCCESS:
                currentUser.addLog(new Log("Задание " + nameQuestion + " выполнено", getCurrentTime()));
                delQuestion(nameQuestion);
                return ResultRunningProgram.SUCCESS;
            default :
                currentUser.addLog(new Log("Неизвестная ошибка", getCurrentTime()));
                return ResultRunningProgram.UNKNOWN_ERROR;
        }
    }

    private String getCurrentTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" +
                calendar.get(Calendar.SECOND);
    }

    private void delQuestion(String title){
        currentUser.removeQuestion(title);
    }

    public void finishOlympiad(){
        currentUser.getQuestionsUser().clear();
        currentUser.getLogsUser().clear();
    }

}