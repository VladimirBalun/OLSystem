package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.dao.QuestionsDAO;
import ru.testingsystem.data.entity.Question;

import java.util.List;

@Log4j
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDAO questionsDAO;

    @Transactional
    public void addQuestion(String titleQuestion, String textQuestion) {
        questionsDAO.addQuestion(new Question(titleQuestion, textQuestion));
        log.debug("Question " + titleQuestion + " was added");
    }

    @Transactional
    public void removeQuestion(String titleQuestion) {
        questionsDAO.removeQuestion(titleQuestion);
        log.debug("Question " + titleQuestion + " was added");
    }

    @Transactional
    public void changeQuestion(String nameQuestion, String newTitle, String newText) {
        questionsDAO.changeQuestion(nameQuestion, newTitle, newText);
        log.debug("Question " + nameQuestion + " was changed on " + newTitle + " : " + newText);
    }

    public Question getQuestion(String titleQuestion) {
        return questionsDAO.getQuestion(titleQuestion);
    }

    public int getCountQuestions(){
        return questionsDAO.getCountQuestions();
    }

    public List<Question> getQuestions() {
        return questionsDAO.getQuestions();
    }

}
