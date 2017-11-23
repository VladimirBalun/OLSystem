package ru.tidstu.testingsystem.models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Balun Vladimir
 */
public class IOFile {

    /**
     *
     * @param filePath
     * @return
     */
    public static String readFile(String filePath){
        StringBuffer txt = new StringBuffer();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String line: lines){
            txt.append(line);
        }
        return txt.toString();
    }

    /**
     *
     * @param filePath
     * @param data
     */
    public static void writeFile(String filePath, String data){

    }

}
