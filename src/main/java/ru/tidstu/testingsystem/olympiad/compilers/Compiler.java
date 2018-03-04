package ru.tidstu.testingsystem.olympiad.compilers;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.data.entity.TestData;

import java.io.*;
import java.util.List;

/**
 * This class provides methods for compilation and running program. Compilation
 * of program is occurs by creating source file, the text which will be passed
 * in the method. Running of program is occurs by testing of test data.
 */
@Log4j
public abstract class Compiler {

    /**
     * Path to package of resources, where will save sources and executables file during Olympic.
     * You can delete this directory, but you will need to create a new directory and change
     * the name bellow.
     */
    String pathSourceProgram = new File(getClass().getClassLoader().getResource("sources").getPath()).getAbsolutePath();;

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

    BufferedReader runCommand(String command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStream inStream = process.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        return new BufferedReader(inStreamReader);
    }

}
