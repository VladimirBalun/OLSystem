package ru.testingsystem.checkingTask;

import lombok.extern.log4j.Log4j;

import java.io.*;

@Log4j
public class Terminal {

    private final String NAME_TERMINAL = System.getProperty("os.name").startsWith("Windows") ? "cmd.exe" : "bash";
    private final String PATH_SOURCE_FILES = System.getProperty("user.home") + "/ATSSources/";
    private final String COMMAND_FORWARD_TO_SOURCES = "cd " + PATH_SOURCE_FILES;

    public Terminal(){
        final File catalogSources = new File(PATH_SOURCE_FILES);
        if(!catalogSources.exists()) {
            if(!catalogSources.mkdir()) {
                log.fatal("Catalog for source files wasn't created. Path: " + PATH_SOURCE_FILES);
            }
        }
    }

    public BufferedReader runCommand(String command) throws IOException{
        ProcessBuilder processBuilder = new ProcessBuilder(NAME_TERMINAL, "-c", COMMAND_FORWARD_TO_SOURCES + " && " + command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStream inStream = process.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        return new BufferedReader(inStreamReader);
    }

    public boolean createSourceFile(String fileName, String textSource){
        boolean isCreated = true;
        try {
            FileWriter writer = new FileWriter(PATH_SOURCE_FILES + fileName, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(textSource);
            bufferWriter.close();
        }
        catch (IOException e) {
            log.error("Error of creating source file. Path: " + PATH_SOURCE_FILES + fileName);
            isCreated = false;
        }
        return isCreated;
    }

    public boolean removeSourceAndExeFiles(String ... fileNames){
        boolean isDeleted = true;
        for (String name : fileNames){
            File file = new File(PATH_SOURCE_FILES + name);
            if(!file.delete()){
                log.warn("File [" + name + "] wasn't deleted. Path: " + PATH_SOURCE_FILES);
                isDeleted = false;
            }
        }
        return isDeleted;
    }

}
