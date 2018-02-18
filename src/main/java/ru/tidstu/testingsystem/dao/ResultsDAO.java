package ru.tidstu.testingsystem.dao;

import ru.tidstu.testingsystem.domain.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

public interface ResultsDAO {

    public List<Result> getResultsOfUsers(SortingResults method);

}
