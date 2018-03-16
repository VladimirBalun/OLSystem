package ru.testingsystem.data.service;

import ru.testingsystem.data.domain.TestDataQuestion;

import java.util.List;

public interface TestDataService {

    void addTestDataForQuestion(String nameQuestion, String inputData, String outputData);

    List<TestDataQuestion> getTestDataForQuestion(String nameQuestion);

}
