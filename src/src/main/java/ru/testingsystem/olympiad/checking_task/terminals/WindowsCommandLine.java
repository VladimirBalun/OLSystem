package ru.testingsystem.olympiad.checking_task.terminals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WindowsCommandLine implements Terminal {

    public BufferedReader runCommand(String command) {
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
