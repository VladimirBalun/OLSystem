package ru.tidstu.testingsystem.models;

import org.apache.log4j.LogManager;

import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 *
 * @author Balun Vladimir
 */
public class FirebirdDB {


    private final static Logger log = LogManager.getLogger(FirebirdDB.class);
    private static FirebirdDB firebirdDB = new FirebirdDB();

    /**
     * Common object's for work with database.
     */
    private Connection connection;
    private Properties connectionInfo = new Properties();;
    private ResultSet result;

    /**
     *
     */
    public void connect(){
        String urlDB = "jdbc:firebirdsql:localhost/3050:C:\\Users\\User\\Desktop\\TestingSystem\\src\\main\\resources\\DB.FDB";
        connectionInfo.put("user", "SYSDBA");
        connectionInfo.put("password", "masterkey");
        connectionInfo.put("charSet", "Cp1251");

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } catch (ClassNotFoundException e) {
            log.error("Not found driver for FireBird");
        }

        try {
            connection = null;
            connection = DriverManager.getConnection(urlDB, connectionInfo);
            if(connection == null) {
                log.info("Database isn't open.");
                return;
            } else {
                log.info("Database is open.");
            }
        } catch (SQLException e) {
            log.error("Error in the DriverManager.");
        }
    }

    /**
     *
     */
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Error of closing database.");
        }
    }


    /**
     *
     * @param query string for query
     * @return result of query
     */
    public ResultSet execSelect(String query){
        try {
            Statement stmt = connection.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            log.error("Error in the SELECT query(" + query +").");
        } catch (NullPointerException e){
            log.error("Error in the statement of SELECT query.");
        }
        return result;
    }

    /**
     *
     * @param query string for query
     */
    public void execInsert(String query){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            log.error("Error in the INSERT query(" + query +").");
        }
    }

    /**
     * Getter return instance of current class.
     * @return instance of current class
     */
    public static FirebirdDB getInstance() {
        return firebirdDB;
    }

    /**
     * Getter return opening of connection with database.
     * @return opening connection with database
     */
    public Connection getConnection(){
        return connection;
    }

    /**
     * Private constructor run initial connection with database.
     */
    private FirebirdDB(){
        connect();
    }

}
