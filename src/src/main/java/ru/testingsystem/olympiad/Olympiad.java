package ru.testingsystem.olympiad;

import ru.testingsystem.data.entity.Log;
import ru.testingsystem.data.entity.Question;

import java.util.List;
import java.util.Queue;

public interface Olympiad {

    void startOlympiad(String login, String password);

    String checkTask(String nameQuestion, String textProgram);

    String getStatisticUser();

    List<Question> getQuestions();

    Question getQuestion(String title);

    Queue<Log> getLogsOfRunningTest();

    void finishOlympiad();

}
