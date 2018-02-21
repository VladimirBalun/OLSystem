package ru.tidstu.testingsystem.data.dao;

import ru.tidstu.testingsystem.data.entity.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

public interface ResultsDAO {

    public List<Result> getResultsOfUsers(SortingResults method);

}
