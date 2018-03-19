package ru.testingsystem.checkingTask.compilers;

import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.checkingTask.Program;
import ru.testingsystem.checkingTask.ResultCheckingProgram;
import ru.testingsystem.checkingTask.Terminal;

import java.util.List;

public abstract class Compiler implements Program {

    Terminal terminal = new Terminal();

    public abstract ResultCheckingProgram checkProgram(String nameQuestion, String textProgram, List<TestData> testData);

    protected abstract boolean compileProgram(String textProgram);

    protected abstract boolean runProgram(List<TestData> testData);

}
