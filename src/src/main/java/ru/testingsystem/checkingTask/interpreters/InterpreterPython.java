package ru.testingsystem.checkingTask.interpreters;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import ru.testingsystem.checkingTask.ResultCheckingProgram;
import ru.testingsystem.data.entity.TestData;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Log4j
@Component
public class InterpreterPython extends Interpreter{

    private final String FILE_EXTENSION = ".py";
    private final String FILE_NAME = "main";
    private final String SOURCE_FILE = FILE_NAME + FILE_EXTENSION;

    @Override
    public ResultCheckingProgram checkProgram(String nameQuestion, String textProgram, List<TestData> testData) {
        if(!terminal.createSourceFile(SOURCE_FILE, textProgram)){
            return ResultCheckingProgram.ERROR_CREATION_SOURCE_FILE;
        }
        if(!runProgram(testData)){
            return ResultCheckingProgram.ERROR_RUNNING_PROGRAM;
        }
        return ResultCheckingProgram.SUCCESS;
    }

    @Override
    protected boolean runProgram(List<TestData> testDataForProgram) {
        boolean resultRunningProgram;
        try {
            resultRunningProgram = testProgram(testDataForProgram);
        } catch (IOException e){
            resultRunningProgram = false;
            log.error("Error running program or reading result program.");
        } finally {
            terminal.removeSourceAndExeFiles(SOURCE_FILE);
        }
        return resultRunningProgram;
    }

    private boolean testProgram(List<TestData> testDataForProgram) throws IOException{
        String commandRunning = "python " + SOURCE_FILE; // python nameSource.py
        for (TestData testData : testDataForProgram){
            BufferedReader buffReader = terminal.runCommand(commandRunning + " " + testData.getInputData());
            String outputProgram = buffReader.readLine();
            if(outputProgram == null || !outputProgram.equals(testData.getOutputData())) {
                return false;
            }
        }
        return true;
    }

}
