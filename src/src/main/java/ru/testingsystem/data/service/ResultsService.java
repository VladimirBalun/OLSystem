package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.Result;
import ru.testingsystem.data.dao.SortingResults;

import java.util.List;

public interface ResultsService {

    List<Result> getResultsOfUsers(SortingResults method);

}
