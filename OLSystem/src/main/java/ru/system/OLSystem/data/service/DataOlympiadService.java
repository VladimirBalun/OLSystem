package ru.system.OLSystem.data.service;

import ru.system.OLSystem.data.entity.DataOlympiad;

import java.util.List;

public interface DataOlympiadService {

    List<DataOlympiad> getAllDataOlympiad();

    boolean changeDataOlympiadByName(String name, String newData);

    boolean changeDataOlympiad(DataOlympiad[] dataOlympiads);

}
