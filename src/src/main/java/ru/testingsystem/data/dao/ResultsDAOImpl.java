package ru.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.testingsystem.data.entity.Result;
import ru.testingsystem.data.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class ResultsDAOImpl implements ResultsDAO {

    private DataBase dataBase = DataBase.getInstance();

    public List<Result> getResultsOfUsers(SortingResults method){
        ArrayList<Result> results = new ArrayList<Result>();
        String query = selectMethodOfSorting(method);
        ResultSet resultQuery = dataBase.execSelect(query);
        try {
            while(resultQuery.next()){
                Result resultUser = Result.builder()
                        .name(resultQuery.getString(1))
                        .group(resultQuery.getString(2))
                        .dateOfResult(resultQuery.getTimestamp(3))
                        .result(resultQuery.getString(4) + "/" + resultQuery.getString(5))
                        .build();
                results.add(resultUser);
            }
        } catch (SQLException e) {
            log.error("Error is reading results of users. Query: " + query);
        }
        return results;
    }

    private String selectMethodOfSorting(SortingResults method){
        String query = "SELECT u.full_name, (SELECT g.name_group FROM groups g WHERE g.id = u.id_group), " +
                       "r.date_end, r.count_true_answers, r.count_questions " +
                       "FROM results r " +
                       "LEFT JOIN users u ON r.id_user = u.id ";
        switch (method){
            case DATE:
                query += "ORDER BY r.date_end DESC";
                break;
            case NAME:
                query += "ORDER BY u.full_name";
                break;
            case RESULT:
                query += "ORDER BY (r.count_true_answers / r.count_questions * 100) DESC";
                break;
        }
        return query;
    }

}
