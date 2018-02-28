package ru.tidstu.testingsystem.data.service;

import com.sun.istack.internal.NotNull;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.QuestionsDAO;
import ru.tidstu.testingsystem.data.entity.Question;

import java.util.List;

@Log4j
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDAO questionsDAO;

    @Transactional
    public void addQuestion(Question question) {
        questionsDAO.addQuestion(question);
        log.debug("Question " + question.getTitle() + " was added");
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

    public List<Question> getQuestions() {
        return questionsDAO.getQuestions();
    }

}
