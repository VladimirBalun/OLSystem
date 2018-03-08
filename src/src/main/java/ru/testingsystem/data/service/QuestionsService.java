package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.Question;

import java.util.List;

public interface QuestionsService {

    void addQuestion(String titleQuestion, String txtQuestion);

    void removeQuestion(String titleQuestion);

    void changeQuestion(String nameQuestion, String newTitle, String newText);

    Question getQuestion(String titleQuestion);

    int getCountQuestions();

    List<Question> getQuestions();

}
