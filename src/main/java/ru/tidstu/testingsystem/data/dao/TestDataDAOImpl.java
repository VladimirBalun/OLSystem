package ru.tidstu.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.tidstu.testingsystem.data.entity.TestData;
import ru.tidstu.testingsystem.utils.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class TestDataDAOImpl implements TestDataDAO {

    private DataBase dataBase = DataBase.getInstance();

    public void addTestDataForQuestion(String nameQuestion, String inputData, String outputData){
        String query = "INSERT INTO in_out_dates(in_date, out_date, id_question) " +
                       "VALUES('" + inputData + "', '" + outputData + "', " +
                       "(SELECT q.id FROM questions q WHERE q.title = '" + nameQuestion + "'))";
        dataBase.execInsert(query);
    }

    public List<TestData> getTestDataForQuestion(String nameQuestion){
        List<TestData> testDataForQuestion = new ArrayList<TestData>();
        String query = "SELECT io.in_date, io.out_date " +
                       "FROM in_out_dates io " +
                       "WHERE io.id_question = (SELECT q.id FROM questions q WHERE q.title = '" + nameQuestion + "')";
        ResultSet resultQuery = dataBase.execSelect(query);
        try {
            while(resultQuery.next()){
                String inputData = resultQuery.getString(1);
                String outputData = resultQuery.getString(2);
                TestData testData = new TestData(inputData, outputData);
                testDataForQuestion.add(testData);
            }
        } catch (SQLException e) {
            log.error("Error is reading test data for Question. Query: " + query);
        }
        return testDataForQuestion;
    }

}
