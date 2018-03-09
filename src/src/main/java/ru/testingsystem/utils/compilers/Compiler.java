package ru.testingsystem.utils.compilers;

import ru.testingsystem.data.entity.TestData;

import java.util.List;

public interface Compiler {

    boolean compileProgram(String textProgram);

    boolean runProgram(List<TestData> testData);

}
