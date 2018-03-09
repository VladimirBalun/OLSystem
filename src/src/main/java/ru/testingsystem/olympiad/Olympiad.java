package ru.testingsystem.olympiad;

import ru.testingsystem.data.entity.Log;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.utils.compilers.ResultRunningProgram;

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
