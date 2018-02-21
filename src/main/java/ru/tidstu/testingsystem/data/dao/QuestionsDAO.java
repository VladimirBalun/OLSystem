package ru.tidstu.testingsystem.data.dao;

import ru.tidstu.testingsystem.data.entity.Question;

import java.util.List;

public interface QuestionsDAO {

        public void addQuestion(Question question);

        public void removeQuestion(String titleQuestion);

        public void changeQuestion(String nameQuestion, String newTitle, String newText);

        public Question getQuestion(String titleQuestion);

        public List<Question> getAllQuestions();

}
