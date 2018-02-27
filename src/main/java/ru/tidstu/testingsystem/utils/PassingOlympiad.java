package ru.tidstu.testingsystem.utils;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tidstu.testingsystem.compilers.Compiler;
import ru.tidstu.testingsystem.compilers.CompilerC;
import ru.tidstu.testingsystem.compilers.ResultRunningProgram;
import ru.tidstu.testingsystem.data.entity.Log;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.data.entity.TestData;
import ru.tidstu.testingsystem.data.service.QuestionsService;

import java.util.LinkedList;
import java.util.List;

@Log4j
@Component
public class PassingOlympiad implements Olympiad {

    private final int MAX_COUNT_LOGS_IN_JOURNAL = 9;

    private List<Question> questions;
    private List<Log> logsOfRunningOlympiad;

    @Autowired
    public PassingOlympiad(QuestionsService questionsService) {
        QuestionsService questionsService1 = questionsService;
        this.questions = questionsService.getAllQuestions();
        this.logsOfRunningOlympiad = new LinkedList<Log>();
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
        if(logsOfRunningOlympiad.size() > MAX_COUNT_LOGS_IN_JOURNAL){
            logsOfRunningOlympiad.remove(0);
            log.debug("Delete log");
        }
        logsOfRunningOlympiad.add(logRunningOlympiad);
    }

    public List<Log> getLogsOfRunningTest(){
        for (Log log : logsOfRunningOlympiad){
            System.out.println(log.toString());
        }
        return logsOfRunningOlympiad;
    }

    public ResultRunningProgram checkTask(String textProgram, List<TestData> testData){
        Compiler compiler = new CompilerC();
        if(!compiler.compileProgram(textProgram)){
            return ResultRunningProgram.ERROR_COMPILATION;
        }
        if(!compiler.runProgram(testData)){
            return ResultRunningProgram.LOGIC_ERROR_IN_PROGRAM;
        } else {
            return ResultRunningProgram.SUCCESS;
        }
    }

}