package ru.tidstu.testingsystem.data.service;

import ru.tidstu.testingsystem.data.entity.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

public interface ResultsService {

    List<Result> getResultsOfUsers(SortingResults method);

}