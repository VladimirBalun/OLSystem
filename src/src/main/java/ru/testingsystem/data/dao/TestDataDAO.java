package ru.testingsystem.data.dao;

import ru.testingsystem.data.entity.TestData;

import java.util.List;

public interface TestDataDAO {

    void addTestDataForQuestion(String nameQuestion, String inputData, String outputData);

    List<TestData> getTestDataForQuestion(String nameQuestion);

}
