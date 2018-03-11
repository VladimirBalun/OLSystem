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

    private void changeDataByName(String name, String data){
        String query = "UPDATE basic_data SET data = '" + data + "' " +
                        "WHERE name = '" + name + "'";
        dataBase.execUpdate(query);
        basicData.put(name, data);
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

    public String getProgrammingLanguageOlympiad(){
        return basicData.get("languageOlympiad");
    }

    public String getTimePassingOlympiad() {
        return basicData.get("timeOlympiad");
    }

    public void setTitleTestingSystem(String titleOfTest){
        changeDataByName("titleTestingSystem", titleOfTest);
    }

    public void setDescriptionTestingSystem(String descriptionOfTest){
        changeDataByName("descriptionTestingSystem", descriptionOfTest);
    }

    public void setTitleResultOlympiad(String titleOfResult){
        changeDataByName("titleResultOlympiad", titleOfResult);
    }

    public void setDescriptionResultOlympiad(String descriptionOfResult){
        changeDataByName("descriptionResultOlympiad", descriptionOfResult);
    }

    public void setAddressCollege(String address){
        changeDataByName("addressCollege", address);
    }

    public void setPhoneNumberCollege(String phoneNumber){
        changeDataByName("phoneNumberCollege", phoneNumber);
    }

    public void setNameCollege(String nameOfCollege){
        changeDataByName("nameCollege", nameOfCollege);
    }

    public void setProgrammingLanguageOlympiad(String nameLanguage){
        changeDataByName("languageOlympiad", nameLanguage);
    }

    public void setTimePassingOlympiad(String time) {
        changeDataByName("timeOlympiad", time);
    }

}
