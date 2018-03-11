package ru.testingsystem.olympiad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.data.service.TestDataService;
import ru.testingsystem.utils.compilers.Compiler;

import java.util.List;

@Component
public class CheckingProgram {

    @Autowired
    @Qualifier("compilerOrInterpreterForOlympiad")
    private Compiler compiler;

    private final TestDataService testDataService;

    @Autowired
    public CheckingProgram(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    public ResultRunningProgram checkTask(String nameQuestion, String textProgram){
        List<TestData> testData = testDataService.getTestDataForQuestion(nameQuestion);
        System.out.println("Checking program Is empty : " + testData.isEmpty());
        if(!compiler.compileProgram(textProgram)){
            return ResultRunningProgram.ERROR_COMPILATION;
        }
        if(!compiler.runProgram(testData)){
            return ResultRunningProgram.LOGIC_ERROR_IN_PROGRAM;
        } else {
            return ResultRunningProgram.SUCCESS;
        }
    }

}
