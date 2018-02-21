package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.TestDataDAO;

@Log4j
public class TestDataServiceImpl implements TestDataService {

    @Autowired
    private TestDataDAO testDataDAO;

    @Transactional
    public void addTestDataForQuestion(String nameQuestion, String inputData, String outputData) {
        testDataDAO.addTestDataForQuestion(nameQuestion, inputData, outputData);
    }

}