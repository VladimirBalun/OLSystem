package ru.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.testingsystem.data.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Repository
public class BasicDataDAOImpl implements BasicDataDAO {

    private Map<String, String> basicData = new HashMap<>();
    private DataBase dataBase = DataBase.getInstance();

    public BasicDataDAOImpl(){
        loadDataFromDB();
    }

    private void loadDataFromDB(){
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
        basicData.clear();
        loadDataFromDB();
    }

    public String getTitleTestingSystem(){
        return basicData.get("titleTestingSystem");
    }

    public String getDescriptionTestingSystem(){
        return basicData.get("descriptionTestingSystem");
    }

    public String getTitleResultOlympiad(){
        return basicData.get("titleResultOlympiad");
    }

    public String getDescriptionResultOlympiad(){
        return basicData.get("descriptionResultOlympiad");
    }

    public String getAddressCollege(){
        return basicData.get("addressCollege");
    }

    public String getPhoneNumberCollege(){
        return basicData.get("phoneNumberCollege");
    }

    public String getNameCollege(){
        return basicData.get("nameCollege");
    }

    public void setTitleTestingSystem(String titleOfTest){
        reloadDataInDB("titleTestingSystem", titleOfTest);
    }

    public void setDescriptionTestingSystem(String descriptionOfTest){
        reloadDataInDB("descriptionTestingSystem", descriptionOfTest);
    }

    public void setTitleResultOlympiad(String titleOfResult){
        reloadDataInDB("titleResultOlympiad", titleOfResult);
    }

    public void setDescriptionResultOlympiad(String descriptionOfResult){
        reloadDataInDB("descriptionResultOlympiad", descriptionOfResult);
    }

    public void setAddressCollege(String address){
        reloadDataInDB("addressCollege", address);
    }

    public void setPhoneNumberCollege(String phoneNumber){
        reloadDataInDB("phoneNumberCollege", phoneNumber);
    }

    public void setNameCollege(String nameOfCollege){
        reloadDataInDB("nameCollege", nameOfCollege);
    }

}
