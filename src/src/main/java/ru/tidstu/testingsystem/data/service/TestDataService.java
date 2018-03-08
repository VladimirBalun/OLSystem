package ru.tidstu.testingsystem.data.service;

import ru.tidstu.testingsystem.data.entity.TestData;

import java.util.List;

public interface TestDataService {

    void addTestDataForQuestion(String nameQuestion, String inputData, String outputData);

    List<TestData> getTestDataForQuestion(String nameQuestion);

}
