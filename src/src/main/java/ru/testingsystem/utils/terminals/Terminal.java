package ru.testingsystem.utils.terminals;

import lombok.extern.log4j.Log4j;
import ru.testingsystem.data.entity.TestDataQuestion;

import java.io.*;
import java.util.List;

@Log4j
public abstract class Terminal {

    String pathSourceAndExePrograms = System.getProperty("user.home") + "/AFSSources/";
    String commandForwardToCatalog = "cd " + pathSourceAndExePrograms;

    abstract public boolean compile(String commandCompilation, String nameFile, String fileExtension, String textProgram);
    abstract public boolean runExeProgram(String nameFile, String fileExtension, List<TestDataQuestion> testData);
    abstract public boolean runByteCodeProgram(String nameVM, String nameFile, String fileExtension, List<TestDataQuestion> testData);

    public Terminal(){
        final File catalogSources = new File(pathSourceAndExePrograms);
        if(!catalogSources.exists()) {
            catalogSources.mkdir();
        }
    }

    void createSourceFile(String nameFile, String fileExtension, String textProgram){
        try {
            FileWriter writer = new FileWriter(pathSourceAndExePrograms + nameFile + fileExtension, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(textProgram);
            bufferWriter.close();
        }
        catch (IOException e) {
            log.error("Error of creating source file. Path: " + pathSourceAndExePrograms + nameFile);
        }
    }

    void removeSourceAndExeFile(String nameSourceFile, String nameExeFile){
        File source = new File(pathSourceAndExePrograms + nameSourceFile);
        if(!source.delete()) {
            log.warn("Source file wasn't deleted");
        }
        File exe = new File(pathSourceAndExePrograms + nameExeFile);
        if(!exe.delete()) {
            log.warn("Exe file wasn't deleted");
        }
    }

}
