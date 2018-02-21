package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tidstu.testingsystem.data.dao.ResultsDAO;
import ru.tidstu.testingsystem.data.entity.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

@Log4j
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private ResultsDAO resultsDAO;

    public List<Result> getResultsOfUsers(SortingResults method){
        return resultsDAO.getResultsOfUsers(method);
    }

}
