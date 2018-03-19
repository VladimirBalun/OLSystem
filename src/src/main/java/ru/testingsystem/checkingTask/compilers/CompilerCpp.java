package ru.testingsystem.checkingTask.compilers;

import lombok.extern.log4j.Log4j;
import ru.testingsystem.checkingTask.ResultCheckingProgram;
import ru.testingsystem.data.entity.TestData;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Log4j
public class CompilerCpp extends Compiler {

    private final String FILE_EXTENSION = ".cpp";
    private final String FILE_NAME = "main";
    private final String SOURCE_FILE = FILE_NAME + FILE_EXTENSION;

    @Override
    public ResultCheckingProgram checkProgram(String nameQuestion, String textProgram, List<TestData> testData) {
        if(!terminal.createSourceFile(SOURCE_FILE, textProgram)){
            return ResultCheckingProgram.ERROR_CREATION_SOURCE_FILE;
        }
        if(!compileProgram(textProgram)){
            return ResultCheckingProgram.ERROR_COMPILATION;
        }
        if(!runProgram(testData)){
            return ResultCheckingProgram.ERROR_RUNNING_PROGRAM;
        }
        return ResultCheckingProgram.SUCCESS;
    }

    @Override
    protected boolean compileProgram(String textProgram) {
        boolean resultCompilation = false;
        String commandCompilation = "g++ " + SOURCE_FILE + " -o " + FILE_NAME; //g++ nameSource.c -o nameSource
        try {
            BufferedReader buffReader = terminal.runCommand(commandCompilation);
            if(buffReader.readLine() == null){
                resultCompilation = true;
            } else {
                terminal.removeSourceAndExeFiles(SOURCE_FILE);
            }
        } catch (IOException e) {
            log.error("Error compilation or reading result compilation. Command: " + commandCompilation);
        }
        return resultCompilation;
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
            terminal.removeSourceAndExeFiles(SOURCE_FILE, FILE_NAME);
        }
        return resultRunningProgram;
    }

    private boolean testProgram(List<TestData> testDataForProgram) throws IOException{
        String commandRunning = getCommandRunningProgram(); // ./nameSource or nameSource.exe
        for (TestData testData : testDataForProgram){
            BufferedReader buffReader = terminal.runCommand(commandRunning + " " + testData.getInputData());
            String outputProgram = buffReader.readLine();
            if(outputProgram == null || !outputProgram.equals(testData.getOutputData())) {
                return false;
            }
        }
        return true;
    }

    private String getCommandRunningProgram(){
        String operatingSystem = System.getProperty("os.name");
        if(operatingSystem.startsWith("Windows")){
            return FILE_NAME + ".exe";
        } else {
            return "./" + FILE_NAME;
        }
    }

}
