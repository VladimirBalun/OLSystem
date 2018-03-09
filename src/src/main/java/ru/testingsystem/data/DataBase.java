package ru.testingsystem.data;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.Properties;

@Log4j
public class DataBase {

    @Getter
    private static DataBase instance = new DataBase();
    private Properties connectionInfo = new Properties();
    private Connection connection;
    private ResultSet result;

    private DataBase(){
        connect();
    }

    private void connect(){
        String urlDB = "jdbc:mysql://localhost:3306/TestingSystem";
        connectionInfo.put("user", "root");
        connectionInfo.put("password", "admin");
        connectionInfo.put("charSet", "utf8");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Not found driver for FireBird");
        }
        try {
            connection = DriverManager.getConnection(urlDB, connectionInfo);
            if(connection == null) {
                log.error("Database isn't open.");
            } else {
                log.info("Database is open.");
            }
        } catch (SQLException e) {
            log.error("Error connection with Database");
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