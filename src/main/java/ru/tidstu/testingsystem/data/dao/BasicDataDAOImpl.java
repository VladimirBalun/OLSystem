package ru.tidstu.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.tidstu.testingsystem.utils.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Repository
public class BasicDataDAOImpl implements BasicDataDAO {

    private Map<String, String> basicData = new HashMap<String, String>();
    private DataBase dataBase = DataBase.getInstance();

    public BasicDataDAOImpl(){
        loadDataFromDB();
    }

    private void loadDataFromDB(){
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
            log.error("Error is reading basic data. Query: " + query);
        }
    }

    private void reloadDataInDB(String name, String data){
        String strQuery = "UPDATE basic_data SET data = '" + data + "' " +
                "WHERE name = '" + name + "'";
        dataBase.execUpdate(strQuery);
        //Update basic data
        loadDataFromDB();
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
