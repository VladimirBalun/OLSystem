package ru.tidstu.testingsystem.utils;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tidstu.testingsystem.data.entity.Log;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.data.service.QuestionsService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Log4j
public class PassingOlympiad implements Olympiad {

    private final int MAX_COUNT_LOGS_IN_JOURNAL = 5;
    private final QuestionsService questionsService;

    private List<Question> questions;
    private Queue<Log> logsOfRunnungOlympiad;

    @Autowired
    public PassingOlympiad(QuestionsService questionsService) {
        this.questionsService = questionsService;
        this.questions = questionsService.getAllQuestions();
        this.logsOfRunnungOlympiad = new LinkedList<Log>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(int number){
        for (Question question : questions) {
            if(question.getNumber() == number){
                return question;
            }
        }
        return null;
    }

    public void delQuestion(String title){
        for (Question question : questions) {
            log.debug(question.toString());
            if(question.getTitle().equals(title)){
                questions.remove(question);
                return;
            }
        }
    }

    public void addLog(Log logRunningOlympiad){
        log.debug("Add log");
        if(logsOfRunnungOlympiad.size() > MAX_COUNT_LOGS_IN_JOURNAL){
            logsOfRunnungOlympiad.remove();
            log.debug("Delete log");
        }
        logsOfRunnungOlympiad.add(logRunningOlympiad);
        for (Log log : logsOfRunnungOlympiad){
            System.out.println(log.toString());
        }
    }

    public Queue<Log> getLogsOfRunningTest(){
        return logsOfRunnungOlympiad;
    }

}