package ru.testingsystem.data.dao;

import ru.testingsystem.data.entity.Result;

import java.util.List;

public interface ResultsDAO {

    List<Result> getResultsOfUsers(SortingResults method);

}
