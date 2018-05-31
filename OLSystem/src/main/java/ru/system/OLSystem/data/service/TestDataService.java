package ru.system.OLSystem.data.service;

import ru.system.OLSystem.data.entity.TestData;

import java.util.List;

public interface TestDataService {

    List<TestData> getAllTestData();

    List<TestData> getTestDataForTask(String titleTask);

    boolean addNewTestDataForTask(String titleTask, String inputData, String outputData);

    boolean removeTestDataByInoutAndOutputData(String inputData, String outputData);

}
