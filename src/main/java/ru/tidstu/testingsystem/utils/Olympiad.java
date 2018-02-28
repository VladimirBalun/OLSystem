package ru.tidstu.testingsystem.utils;

import ru.tidstu.testingsystem.compilers.ResultRunningProgram;
import ru.tidstu.testingsystem.data.entity.Log;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.data.entity.TestData;

import java.util.List;
import java.util.Queue;

public interface Olympiad {

    List<Question> getQuestions();

    Question getQuestion(int number);

    void delQuestion(String title);

    void addLog(Log log);

    List<Log> getLogsOfRunningTest();

    ResultRunningProgram checkTask(String nameQuestion, String textProgram);

}
