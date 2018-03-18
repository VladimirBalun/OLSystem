package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.TestData;

import java.util.List;

public interface TestDataService {

    boolean addTestDataForQuestion(String titleQuestion, String inputData, String outputData);

    boolean removeTestDataQuestion(String inputData, String outputData);

    List<TestData> getTestDataForQuestion(String nameQuestion);

}
