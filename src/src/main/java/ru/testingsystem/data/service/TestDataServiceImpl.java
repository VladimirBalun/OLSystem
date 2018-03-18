package ru.testingsystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.data.repository.QuestionRepository;
import ru.testingsystem.data.repository.TestDataRepository;

import java.util.List;

@Service
public class TestDataServiceImpl implements TestDataService {

    @Autowired
    private TestDataRepository testDataRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public boolean addTestDataForQuestion(String titleQuestion, String inputData, String outputData) {
        Question question = questionRepository.findByTitle(titleQuestion);
        if(question != null){
            TestData testData = TestData.builder()
                    .inputData(inputData)
                    .outputData(outputData)
                    .question(question)
                    .build();
            testDataRepository.saveAndFlush(testData);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeTestDataQuestion(String inputData, String outputData) {
        TestData testData = testDataRepository.findByInputDataAndOutputData(inputData, outputData);
        if(testData != null){
            testDataRepository.deleteByInputDataAndOutputData(inputData, outputData);
            return true;
        } else {
            return false;
        }
    }

    public List<TestData> getTestDataForQuestion(String nameQuestion){
        Question question = questionRepository.findByTitle(nameQuestion);
        return testDataRepository.findByQuestion(question);
    }

}