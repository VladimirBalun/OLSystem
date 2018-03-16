package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.domain.Question;
import ru.testingsystem.data.domain.TestDataQuestion;
import ru.testingsystem.data.repository.QuestionRepository;
import ru.testingsystem.data.repository.TestDataQuestionRepository;

import java.util.List;

@Log4j
@Service
public class TestDataServiceImpl implements TestDataService {

    @Autowired
    private TestDataQuestionRepository testDataQuestionRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public void addTestDataForQuestion(String nameQuestion, String inputData, String outputData) {
        Question question = questionRepository.findByTitle(nameQuestion);
        TestDataQuestion testDataQuestion = new TestDataQuestion(inputData, outputData, question);
        testDataQuestionRepository.saveAndFlush(testDataQuestion);
    }

    public List<TestDataQuestion> getTestDataForQuestion(String nameQuestion){
        return testDataQuestionRepository.findAll();
    }

}