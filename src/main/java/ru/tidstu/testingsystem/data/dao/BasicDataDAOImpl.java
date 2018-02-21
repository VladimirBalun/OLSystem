package ru.tidstu.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.utils.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j
public class BasicDataDAOImpl implements BasicDataDAO {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private static Date date = new Date();
    private Map<String, String> basicData = new HashMap<String, String>();
    private DataBase dataBase = DataBase.getInstance();

    public BasicDataDAOImpl(){
        loadDataFromDB();
    }

    public void loadDataFromDB(){
        basicData.clear();
        String query = "SELECT b.name, b.data FROM basic_data b";
        ResultSet resQuery = dataBase.execSelect(query);
        try {
            while (resQuery.next()){
                String name = resQuery.getString("name");
                String data = resQuery.getString("data");
                basicData.put(name, data);
            }
        } catch (SQLException e) {
            log.error("Error is reading dates from table Basic Data. Query: " + query);
        }
    }

    public String getCurrentDate(){
        return dateFormat.format(date);
    }

    public String getTitleOfTest(){
        return basicData.get("title_of_test");
    }

    public String getDescriptionOfTest(){
        return basicData.get("description_of_test");
    }

    public String getTitleOfResult(){
        return basicData.get("title_of_result");
    }

    public String getDescriptionOfResult(){
        return basicData.get("description_of_result");
    }

    public String getAddress(){
        return basicData.get("address");
    }

    public String getPhoneNumber(){
        return basicData.get("phone_number");
    }

    public String getNameOfCollege(){
        return basicData.get("name_of_college");
    }

    private void reloadDataInDB(String name, String data){
        String strQuery = "UPDATE basic_data SET data = '" + data + "' " +
                          "WHERE name = '" + name + "'";
        dataBase.execUpdate(strQuery);
        //Update basic data
        loadDataFromDB();
    }

    public void setTitleOfTest(String titleOfTest){
        reloadDataInDB("title_of_test", titleOfTest);
    }

    public void setDescriptionOfTest(String descriptionOfTest){
        reloadDataInDB("description_of_test", descriptionOfTest);
    }

    public void setTitleOfResult(String titleOfResult){
        reloadDataInDB("title_of_result", titleOfResult);
    }

    public void setDescriptionOfResult(String descriptionOfResult){
        reloadDataInDB("description_of_result", descriptionOfResult);
    }

    public void setAddress(String address){
        reloadDataInDB("address", address);
    }

    public void setPhoneNumber(String phoneNumber){
        reloadDataInDB("phone_number", phoneNumber);
    }

    public void setNameOfCollege(String nameOfCollege){
        reloadDataInDB("name_of_college", nameOfCollege);
    }

}
