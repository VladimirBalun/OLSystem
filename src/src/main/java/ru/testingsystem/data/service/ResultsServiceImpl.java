package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.ResultOlympiad;
import ru.testingsystem.data.repository.ResultOlympiadRepository;

import java.util.List;

@Log4j
@Service
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private ResultOlympiadRepository resultOlympiadRepository;

    public List<ResultOlympiad> getResultsUsers(){
        return resultOlympiadRepository.findAll();
    }

}
