package ru.tidstu.testingsystem.data.dao;

import ru.tidstu.testingsystem.data.entity.Question;

import java.util.List;

public interface QuestionsDAO {

    void addQuestion(Question question);

    void removeQuestion(String titleQuestion);

    void changeQuestion(String nameQuestion, String newTitle, String newText);

    Question getQuestion(String titleQuestion);

    List<Question> getQuestions();

}
