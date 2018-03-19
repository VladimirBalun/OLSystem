package ru.testingsystem.checkingTask;

import ru.testingsystem.data.entity.TestData;

import java.util.List;

public interface Program {

    ResultCheckingProgram checkProgram(String nameQuestion, String textProgram, List<TestData> testData);

}
