package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.Question;

import java.util.List;

public interface QuestionsService {

    boolean addQuestion(String title, String text);

    boolean removeQuestion(String titleQuestion);

    boolean changeQuestion(String oldTitle, String newTitle, String newText);

    Question getQuestionByTitle(String title);

    long getCountQuestions();

    List<Question> getQuestions();

}
