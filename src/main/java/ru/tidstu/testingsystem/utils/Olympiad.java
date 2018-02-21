package ru.tidstu.testingsystem.utils;

import ru.tidstu.testingsystem.data.entity.Log;
import ru.tidstu.testingsystem.data.entity.Question;

import java.util.List;
import java.util.Queue;

public interface Olympiad {

    List<Question> getQuestions();

    Question getQuestion(int number);

    void delQuestion(String title);

    void addLog(Log log);

    Queue<Log> getLogsOfRunningTest();

}
