package ru.tidstu.testingsystem.services;

import ru.tidstu.testingsystem.domain.Result;
import ru.tidstu.testingsystem.utils.SortingResults;

import java.util.List;

public interface ResultsService {

    public List<Result> getResultsOfUsers(SortingResults method);

}
