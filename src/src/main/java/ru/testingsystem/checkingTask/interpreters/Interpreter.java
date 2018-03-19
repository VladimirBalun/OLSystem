package ru.testingsystem.checkingTask.interpreters;

import ru.testingsystem.checkingTask.Program;
import ru.testingsystem.checkingTask.ResultCheckingProgram;
import ru.testingsystem.checkingTask.Terminal;
import ru.testingsystem.data.entity.TestData;

import java.util.List;

public abstract class Interpreter implements Program {

    Terminal terminal = new Terminal();

    public abstract ResultCheckingProgram checkProgram(String nameQuestion, String textProgram, List<TestData> testData);

    protected abstract boolean runProgram(List<TestData> testData);

}
