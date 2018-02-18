package ru.tidstu.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.dao.TestDataDAO;

public class TestDataServiceImpl implements TestDataService {

    @Autowired
    private TestDataDAO testDataDAO;

    @Transactional
    public void addTestDataForQuestion(String nameQuestion, String inputData, String outputData) {
        testDataDAO.addTestDataForQuestion(nameQuestion, inputData, outputData);
    }

}