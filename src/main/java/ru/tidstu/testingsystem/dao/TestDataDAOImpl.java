package ru.tidstu.testingsystem.dao;

import ru.tidstu.testingsystem.utils.DataBase;

public class TestDataDAOImpl implements TestDataDAO {

    private DataBase dataBase = DataBase.getInstance();

    public void addTestDataForQuestion(String nameQuestion, String inputData, String outputData){
        String query = "INSERT INTO in_out_dates(in_date, out_date, id_question) " +
                       "VALUES('" + inputData + "', '" + outputData + "', " +
                       "(SELECT q.id FROM questions q WHERE q.title = '" + nameQuestion + "'))";
        dataBase.execInsert(query);
    }

}
