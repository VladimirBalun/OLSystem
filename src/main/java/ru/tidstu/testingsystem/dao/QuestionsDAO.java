package ru.tidstu.testingsystem.dao;

import ru.tidstu.testingsystem.domain.Question;

import java.util.List;

public interface QuestionsDAO {

        public void setQuestionsForUser();

        public List<Question> getQuestionsOfUser();

        public Question getQuestionOfUser(int number);

        public void addQuestion(Question question);

        public void removeQuestion(String titleQuestion);

        public void changeQuestion(String nameQuestion, String newTitle, String newText);

        public Question getQuestion(String titleQuestion);

        public List<Question> getAllQuestions();

}
