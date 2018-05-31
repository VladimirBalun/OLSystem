package ru.system.OLSystem.olympiad.utils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connector {

    public static String sendTaskOnCkecking(String jsonText) throws IOException {
        String host = "127.0.0.1";
        int port = 1234;
        InetAddress address = InetAddress.getByName(host);
        Socket socket = new Socket(address, port);

        OutputStream outStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outStream);
        BufferedWriter buffWriter = new BufferedWriter(outputStreamWriter);

        buffWriter.write(jsonText);
        buffWriter.flush();

        InputStream inStream = socket.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        BufferedReader buffReader = new BufferedReader(inStreamReader);
        return buffReader.readLine();
    }

}
