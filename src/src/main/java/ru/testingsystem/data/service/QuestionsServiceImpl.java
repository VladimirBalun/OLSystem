package ru.testingsystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.data.repository.QuestionRepository;
import ru.testingsystem.data.repository.TestDataRepository;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestDataRepository testDataRepository;

    public boolean addQuestion(String title, String text) {
        questionRepository.saveAndFlush(new Question(title, text));
        return true;
    }

    public boolean removeQuestion(String title) {
        Question question = questionRepository.findByTitle(title);
        if(question != null){
            questionRepository.deleteByTitle(title);
            return true;
        } else {
            return false;
        }
    }

    public boolean changeQuestion(String oldTitle, String newTitle, String newText) {
        Question question = questionRepository.findByTitle(oldTitle);
        if(question != null){
            question.setTitle(newTitle);
            question.setText(newText);
            questionRepository.save(question);
            return true;
        } else {
            return false;
        }
    }

    public Question getQuestionByTitle(String title) {
        return questionRepository.findByTitle(title);
    }

    public long getCountQuestions(){
        return questionRepository.count();
    }

    public List<Question> getQuestions() {
        List<Question> questions = questionRepository.findAll();
        for(Question question : questions){
            TestData testData = testDataRepository.findByQuestion(question).get(0);
            if(testData != null){
                question.setInputData(testData.getInputData());
                question.setOutputData(testData.getOutputData());
            }
        }
        return questions;
    }

}