package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.dao.TestDataDAO;
import ru.testingsystem.data.entity.TestData;

import java.util.List;

@Log4j
@Service
public class TestDataServiceImpl implements TestDataService {

    @Autowired
    private TestDataDAO testDataDAO;

    @Transactional
    public void addTestDataForQuestion(String nameQuestion, String inputData, String outputData) {
        testDataDAO.addTestDataForQuestion(nameQuestion, inputData, outputData);
        log.debug("TestDataDAO data [" + inputData + "][" + outputData + "] was added for question " + nameQuestion);
    }

    public List<TestData> getTestDataForQuestion(String nameQuestion){
        return testDataDAO.getTestDataForQuestion(nameQuestion);
    }

}