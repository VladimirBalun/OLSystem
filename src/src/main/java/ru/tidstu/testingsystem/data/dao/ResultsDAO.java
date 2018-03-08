package ru.tidstu.testingsystem.data.dao;

import ru.tidstu.testingsystem.data.entity.Result;

import java.util.List;

public interface ResultsDAO {

    List<Result> getResultsOfUsers(SortingResults method);

}
