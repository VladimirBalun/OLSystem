package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.ResultsDAO;
import ru.tidstu.testingsystem.data.entity.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

@Log4j
@Service
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private ResultsDAO resultsDAO;

    @Transactional
    public List<Result> getResultsOfUsers(SortingResults method){
        return resultsDAO.getResultsOfUsers(method);
    }

}
