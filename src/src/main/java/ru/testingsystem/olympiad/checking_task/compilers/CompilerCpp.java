package ru.testingsystem.olympiad.checking_task.compilers;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.TestData;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Log4j
@Component
public class CompilerCpp extends Compiler {

    @Override
    public boolean compileProgram(String sourceProgram) {
        createSourceFile(pathSourceProgram + "/test.cpp", sourceProgram);
        String command = "cd " + pathSourceProgram + " && g++ test.cpp -o test";
        boolean resultCompilation = false;
        try {
            BufferedReader bufferedReader = terminal.runCommand(command);
            //If result of compilation file doesn't produce errors, then compilation is success
            if(bufferedReader.readLine() == null){
                resultCompilation = true;
            }
        } catch (IOException e) {
            log.error("Error of creating source file. Path: " + pathSourceProgram);
        }
        return resultCompilation;
    }

    @Override
    public boolean runProgram(List<TestData> testDataForProgram) {
        boolean resultRunningProgram = false;
        try {
            resultRunningProgram = testProgramUsingTestData(testDataForProgram);
            removeSourceAndExecutableFile("/test.cpp", "/test.exe");
        } catch (IOException e){
            log.error("Error during test program. File: ");
        }
        return resultRunningProgram;
    }

    private boolean testProgramUsingTestData(List<TestData> testDataForProgram) throws IOException{
        for (TestData testData : testDataForProgram){
            //Goes to the directory with program and runs its with test input data
            BufferedReader bufferedReader = terminal.runCommand("cd " + pathSourceProgram + " && test.exe " + testData.getInputData());
            //If result of executable file equals input test data, then program passes the test
            if(!bufferedReader.readLine().equals(testData.getOutputData())) {
                return false;
            }
        }
        return true;
    }

}
