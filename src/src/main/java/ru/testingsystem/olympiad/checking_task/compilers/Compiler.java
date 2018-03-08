package ru.testingsystem.olympiad.checking_task.compilers;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.olympiad.checking_task.terminals.Terminal;

import java.io.*;
import java.util.List;

/**
 * This class provides methods for compilation and running program. Compilation
 * of program is occurs by creating source file, the text which will be passed
 * in the method. Running of program is occurs by testing of test data.
 */
@Log4j
@Component
public abstract class Compiler {

    @Autowired
    Terminal terminal;

    /**
     * Path to package of resources, where will save sources and executables file during Olympic.
     * You can delete this directory, but you will need to create a new directory and change
     * the name bellow.
     */
    String pathSourceProgram = new File(getClass().getClassLoader().getResource("sources").getPath()).getAbsolutePath();

    abstract public boolean compileProgram(String textProgram);
    abstract public boolean runProgram(List<TestData> testData);

    void createSourceFile(String pathFile, String textProgram){
        try {
            FileWriter writer = new FileWriter(pathFile, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(textProgram);
            bufferWriter.close();
        }
        catch (IOException e) {
            log.error("Error of creating source file. Path: " + pathFile);
        }
    }

    void removeSourceAndExecutableFile(String sourceFile, String exeFile){
        // Deletes source file of the program
        File source = new File(pathSourceProgram + sourceFile);
        if(!source.delete()) {
            log.warn("File test.cpp wasn't deleted");
        }
        // Deletes executable file of the program
        File exe = new File(pathSourceProgram + exeFile);
        if(!exe.delete()) {
            log.warn("File test.exe wasn't deleted");
        }
    }

}
