package ru.tidstu.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.dao.QuestionsDAO;
import ru.tidstu.testingsystem.domain.Question;

import java.util.List;

public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDAO questionsDAO;

    public void setQuestionsForUser() {
        questionsDAO.setQuestionsForUser();
    }

    public List<Question> getQuestionsOfUser() {
        return questionsDAO.getQuestionsOfUser();
    }

    public Question getQuestionOfUser(int number) {
        return questionsDAO.getQuestionOfUser(number);
    }

    @Transactional
    public void addQuestion(Question question) {
        questionsDAO.addQuestion(question);
    }

    @Transactional
    public void removeQuestion(String titleQuestion) {
        questionsDAO.removeQuestion(titleQuestion);
    }

    @Transactional
    public void changeQuestion(String nameQuestion, String newTitle, String newText) {
        questionsDAO.changeQuestion(nameQuestion, newTitle, newText);
    }

    public Question getQuestion(String titleQuestion) {
        return questionsDAO.getQuestion(titleQuestion);
    }

    public List<Question> getAllQuestions() {
        return questionsDAO.getAllQuestions();
    }

}
