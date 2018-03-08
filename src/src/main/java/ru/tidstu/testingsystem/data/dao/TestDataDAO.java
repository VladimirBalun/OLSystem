package ru.tidstu.testingsystem.data.dao;

import ru.tidstu.testingsystem.data.entity.TestData;

import java.util.List;

public interface TestDataDAO {

    void addTestDataForQuestion(String nameQuestion, String inputData, String outputData);

    List<TestData> getTestDataForQuestion(String nameQuestion);

}
