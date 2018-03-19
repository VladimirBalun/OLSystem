package ru.testingsystem.olympiad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.Log;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.data.entity.User;
import ru.testingsystem.data.service.QuestionsService;
import ru.testingsystem.data.service.TestDataService;
import ru.testingsystem.data.service.UsersService;
import ru.testingsystem.checkingTask.Program;

import java.util.*;

@Component
public class OlympiadImpl implements Olympiad {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private TestDataService testDataService;
    @Autowired
    private UsersService usersService;
    @Autowired
    @Qualifier("programForCheckingPrograms")
    private Program program;

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

    public String checkTask(String nameQuestion, String textProgram){
        List<TestData> testData = testDataService.getTestDataForQuestion(nameQuestion);
        switch (program.checkProgram(nameQuestion, textProgram, testData)){
            case ERROR_CREATION_SOURCE_FILE:
                currentUser.addLog(new Log("Ошибка при создании исходника " + nameQuestion, getCurrentTime()));
                return "Ошибка при создании исходника.";
            case ERROR_COMPILATION:
                currentUser.addLog(new Log("Ошибка компиляции в задании " + nameQuestion, getCurrentTime()));
                return "Ошибка компиляции.";
            case ERROR_RUNNING_PROGRAM:
                currentUser.addLog(new Log("Ошибка в тестах для задания " + nameQuestion, getCurrentTime()));
                return "Ошибка во время выполнения программы.";
            case SUCCESS:
                currentUser.addLog(new Log("Задание " + nameQuestion + " выполнено", getCurrentTime()));
                delQuestion(nameQuestion);
                return "Задание успешно выполнено.";
            default :
                currentUser.addLog(new Log("Неизвестная ошибка", getCurrentTime()));
                return "Неизвестная ошибка.";
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