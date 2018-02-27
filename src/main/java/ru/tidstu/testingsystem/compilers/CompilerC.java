package ru.tidstu.testingsystem.compilers;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.data.entity.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Log4j
public class CompilerC extends Compiler {

    @Override
    public boolean compileProgram(String sourceProgram) {
        createSourceFile(pathSourceProgram + "/test.c", sourceProgram);
        String command = "cd " + pathSourceProgram + " && gcc test.c -o test";
        boolean resultCompilation = false;
        try {
            BufferedReader bufferedReader = runCommand(command);
            //If result of compilation file doesn't produce errors, then compilation is success
            if(bufferedReader.readLine() == null){
                resultCompilation = true;
            }
        } catch (IOException e) {
            log.error("Error of creating source file. Path: " + pathSourceProgram);
            resultCompilation = false;
        }
        return resultCompilation;
    }

    @Override
    public boolean runProgram(List<TestData> testDataForProgram) {
        boolean resultRunningProgram;
        try {
            resultRunningProgram = testProgramUsingTestData(testDataForProgram);
            deleteSourceAndExecutableFile();
        } catch (IOException e){
            log.error("Error during test program. File: ");
            resultRunningProgram = false;
        }
        return resultRunningProgram;
    }

    private boolean testProgramUsingTestData(List<TestData> testDataForProgram) throws IOException{
        for (TestData testData : testDataForProgram){
            //Goes to the directory with program and runs its with test input data
            BufferedReader bufferedReader = runCommand("cd " + pathSourceProgram + " && test.exe " + testData.getInputData());
            //If result of executable file equals input test data, then program passes the test
            if(!bufferedReader.readLine().equals(testData.getOutputData())) {
                return false;
            }
        }
        return true;
    }

    private void deleteSourceAndExecutableFile(){
        // Deletes source file of the program
        File sourceFile = new File(pathSourceProgram + "/test.c");
        if(!sourceFile.delete()) {
            log.warn("File test.c wasn't deleted");
        }
        // Deletes executable file of the program
        File exeFile = new File(pathSourceProgram + "/test.exe");
        if(!exeFile.delete()) {
            log.warn("File test.exe wasn't deleted");
        }
    }

}
