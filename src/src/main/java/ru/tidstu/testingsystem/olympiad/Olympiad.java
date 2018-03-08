package ru.tidstu.testingsystem.olympiad;

import ru.tidstu.testingsystem.data.entity.User;
import ru.tidstu.testingsystem.olympiad.compilers.ResultRunningProgram;
import ru.tidstu.testingsystem.data.entity.Log;
import ru.tidstu.testingsystem.data.entity.Question;

import java.util.List;
import java.util.Queue;

public interface Olympiad {

    void startOlympiad(String login, String password);

    ResultRunningProgram checkTask(String nameQuestion, String textProgram);

    String getStatisticUser();

    List<Question> getQuestions();

    Question getQuestion(int number);

    Queue<Log> getLogsOfRunningTest();

    void finishOlympiad();

}
