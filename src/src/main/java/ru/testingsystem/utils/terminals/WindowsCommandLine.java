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
public class WindowsCommandLine extends Terminal {

    @Override
    public boolean compile(String commandCompilation, String nameFile, String fileExtension, String textProgram){
        createSourceFile(nameFile, fileExtension, textProgram);
        String command = commandForwardToCatalog + " && " + commandCompilation;
        log.debug("Command for compile: " + command);
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
    public boolean runProgram(String nameFile, String fileExtension, List<TestData> testDataForProgram) {
        boolean resultRunningProgram = false;
        try {
            resultRunningProgram = testProgramUsingTestData(nameFile, testDataForProgram);
        } catch (IOException e){
            log.error("Error during test program. File: ");
        } finally {
            removeSourceAndExeFile(nameFile + fileExtension, nameFile);
        }
        return resultRunningProgram;
    }

    private boolean testProgramUsingTestData(String nameExeFile, List<TestData> testDataForProgram) throws IOException{
        String commandForRunProgram = commandForwardToCatalog + " && " + nameExeFile + ".exe ";
        for (TestData testData : testDataForProgram){
            BufferedReader bufferedReader = runCommand(commandForRunProgram + testData.getInputData());
            if(!bufferedReader.readLine().equals(testData.getOutputData())) {
                return false;
            }
        }
        return true;
    }

    private BufferedReader runCommand(String command) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
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
