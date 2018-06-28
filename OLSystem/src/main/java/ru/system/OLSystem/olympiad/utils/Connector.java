package ru.system.OLSystem.olympiad.utils;

import org.apache.log4j.Logger;
import ru.system.OLSystem.authentication.AuthenticationImpl;
import ru.system.OLSystem.data.service.DataOlympiadServiceImpl;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

public class Connector {

    private final static Logger logger = Logger.getLogger(DataOlympiadServiceImpl.class);
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(AuthenticationImpl.class.getClassLoader().getResourceAsStream("connector.properties"));
        } catch (IOException e) {
            logger.error("Config file for ProgChecker not found.");
        }
    }

    public static String sendTaskOnCkecking(String jsonText) throws IOException {
        String host = properties.getProperty("progChecker.address");
        int port = Integer.valueOf(properties.getProperty("progChecker.port"));
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
