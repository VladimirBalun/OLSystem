package ru.tidstu.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.tidstu.testingsystem.dao.ResultsDAO;
import ru.tidstu.testingsystem.domain.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private ResultsDAO resultsDAO;

    public List<Result> getResultsOfUsers(SortingResults method){
        return resultsDAO.getResultsOfUsers(method);
    }

}
