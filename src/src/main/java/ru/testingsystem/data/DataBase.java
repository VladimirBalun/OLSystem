package ru.testingsystem.data;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Log4j
public class DataBase {

    @Getter
    private static DataBase instance = new DataBase();

    private Properties properties;
    private Properties connectionInfo = new Properties();
    private Connection connection;
    private ResultSet result;

    private DataBase(){
        try {
            Resource resource = new ClassPathResource("/jdbc.properties");
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            log.error("File with data for connection wasn't read");
        }
        connect();
    }

    private void connect(){
        String urlDB = properties.getProperty("url");
        connectionInfo.put("user", properties.getProperty("user"));
        connectionInfo.put("password", properties.getProperty("password"));
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            log.error("Not found driver for data base");
        }
        try {
            connection = DriverManager.getConnection(urlDB, connectionInfo);
            if(connection == null) {
                log.error("Connection with data base isn't open.");
            } else {
                log.info("Connection with data base is open.");
            }
        } catch (SQLException e) {
            log.error("Error connection with data base");
        }
    }

    public ResultSet execSelect(String query){
        try {
            Statement stmt = connection.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            log.error("Error in the SELECT query(" + query +").");
        } catch (NullPointerException e){
            log.error("Error in the statement of SELECT query(" + query +").");
        }
        return result;
    }

    public void execInsert(String query){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            log.error("Error in the INSERT query(" + query +").");
        }
    }

    public void execUpdate(String query){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            log.error("Error in the UPDATE query(" + query +").");
        }
    }

    public void execDelete(String query){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            log.error("Error in the DELETE query(" + query +").");
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Error of closing database.");
        }
    }

}