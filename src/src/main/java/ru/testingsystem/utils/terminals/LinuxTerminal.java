package ru.testingsystem.utils.terminals;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.TestData;

import java.io.*;
import java.util.List;

@Log4j
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LinuxTerminal extends Terminal{

    @Override
    public boolean compile(String commandCompilation, String nameFile, String fileExtension, String textProgram){
        createSourceFile(nameFile, fileExtension, textProgram);
        String command = commandForwardToCatalog + " && " + commandCompilation;
        log.debug("Command for compile: " + command + " text : \n" + textProgram);
        boolean resultCompilation = false;
        try {
            BufferedReader bufferedReader = runCommand(command);
            if(bufferedReader.readLine() == null){
                resultCompilation = true;
            }
        } catch (IOException e) {
            log.error("Error of creating source file. Path: " + pathSourceAndExePrograms);
        }
        return resultCompilation;
    }

    @Override
    public boolean runExeProgram(String nameFile, String fileExtension, List<TestData> testDataForProgram) {
        boolean resultRunningProgram = false;
        try {
            String commandForRunProgram = (commandForwardToCatalog + " && ./" + nameFile);
            resultRunningProgram = testProgramUsingTestData(commandForRunProgram, testDataForProgram);
        } catch (IOException e){
            log.error("Error during test program. File: ");
        } finally {
            removeSourceAndExeFile(nameFile + fileExtension, nameFile);
        }
        return resultRunningProgram;
    }

    @Override
    public boolean runByteCodeProgram(String nameVM, String nameFile, String fileExtension, List<TestData> testData) {
        boolean resultRunningProgram = false;
        try {
            String commandForRunProgram = (commandForwardToCatalog + " && " + nameVM + " " + nameFile + " ");
            resultRunningProgram = testProgramUsingTestData(commandForRunProgram, testData);
        } catch (IOException e){
            log.error("Error during test program. File: ");
        } finally {
            removeSourceAndExeFile(nameFile + fileExtension, nameFile);
        }
        return resultRunningProgram;
    }

    private boolean testProgramUsingTestData(String commandForRunProgram, List<TestData> testDataForProgram) throws IOException{
        for (TestData testData : testDataForProgram){
            BufferedReader bufferedReader = runCommand(commandForRunProgram + " " + testData.getInputData());
            String resultProgram = bufferedReader.readLine() == null ? "" : bufferedReader.readLine();
            log.debug(commandForRunProgram + testData.getInputData() + "[result = " + resultProgram +" : output = " + testData.getOutputData() +"]");
            if(!resultProgram.equals(testData.getOutputData())) {
                return false;
            }
        }
        return true;
    }

    private BufferedReader runCommand(String command) {
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
        processBuilder.redirectErrorStream(true);
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert process != null;
        InputStream inStream = process.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        return new BufferedReader(inStreamReader);
    }

}
