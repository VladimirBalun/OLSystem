package ru.testingsystem.utils.compilers;

import ru.testingsystem.data.entity.TestDataQuestion;

import java.util.List;

public interface Compiler {

    boolean compileProgram(String textProgram);

    boolean runProgram(List<TestDataQuestion> testDataForProgram);

}
