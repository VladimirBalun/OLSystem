package ru.testingsystem.olympiad;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.Log;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.data.service.QuestionsService;

import java.util.*;

@Log4j
@Component
public class OlympiadImpl implements Olympiad {

    private final int MAX_COUNT_LOGS_IN_JOURNAL = 9;

    private final QuestionsService questionsService;
    private final CheckingProgram checkingProgram;

    //private User currentUser;
    private List<Question> questions;
    private Queue<Log> logsOfRunningOlympiad;

    @Autowired
    public OlympiadImpl(QuestionsService questionsService, CheckingProgram checkingProgram) {
        this.questionsService = questionsService;
        this.checkingProgram = checkingProgram;
        questions = questionsService.getQuestions();
        logsOfRunningOlympiad = new LinkedList<>();
    }

    public void startOlympiad(String login, String password){
//        currentUser = User.builder()
//                .login(login)
//                .password(password)
//                .countTrueAnswers(0)
//                .countQuestions(questionsService.getCountQuestions())
//                .build();
    }

    public String getStatisticUser() {
//        return String.valueOf(currentUser.getCountTrueAnswers() + " / " + currentUser.getCountQuestions());
        return "0/0";
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(String title){
        for (Question question : questions) {
            if(question.getTitle().equals(title)){
                return question;
            }
        }
        return questions.get(0);
    }

    public Queue<Log> getLogsOfRunningTest(){
        return logsOfRunningOlympiad;
    }

    public ResultRunningProgram checkTask(String nameQuestion, String textProgram){
        switch (checkingProgram.checkTask(nameQuestion, textProgram)){
            case ERROR_COMPILATION:
                addLog(new Log("Ошибка компиляции в задании " + nameQuestion, getCurrentTime()));
                return ResultRunningProgram.ERROR_COMPILATION;
            case LOGIC_ERROR_IN_PROGRAM:
                addLog(new Log("Ошибка в тестах для задания " + nameQuestion, getCurrentTime()));
                return ResultRunningProgram.LOGIC_ERROR_IN_PROGRAM;
            case SUCCESS:
                addLog(new Log("Задание " + nameQuestion + " выполнено", getCurrentTime()));
                delQuestion(nameQuestion);
                return ResultRunningProgram.SUCCESS;
            default :
                addLog(new Log("Неизвестная ошибка", getCurrentTime()));
                return ResultRunningProgram.UNKNOWN_ERROR;
        }
    }

    private void addLog(Log log){
        if(logsOfRunningOlympiad.size() > MAX_COUNT_LOGS_IN_JOURNAL){
            logsOfRunningOlympiad.remove();
        }
        logsOfRunningOlympiad.add(log);
    }

    private String getCurrentTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" +
                calendar.get(Calendar.SECOND);
    }

    private void delQuestion(String title){
        for (Question question : questions) {
            if(question.getTitle().equals(title)){
                questions.remove(question);
                return;
            }
        }
    }

    public void finishOlympiad(){
        questions.clear();
        logsOfRunningOlympiad.clear();
    }

}