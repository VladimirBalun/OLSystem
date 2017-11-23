package ru.tidstu.testingsystem;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class FirebirdDBTest {

    Connection connection;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet result;

    @Before
    public void initElements(){

    }

    @Test
    public void connect(){

    }

    @Test(expected = SQLException.class)
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = SQLException.class)
    public void execSelectQuery(){
        String query = "sdf";
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = SQLException.class)
    public void execChangeQuery(){
        String query = "sfs";
        try {
            pstmt = connection.prepareStatement(query);
            result = pstmt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
