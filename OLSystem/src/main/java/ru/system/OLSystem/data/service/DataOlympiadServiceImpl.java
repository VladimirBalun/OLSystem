package ru.system.OLSystem.data.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import ru.system.OLSystem.data.entity.DataOlympiad;
import ru.system.OLSystem.data.dao.DataOlympiadRepository;

import java.util.List;

@Service
public class DataOlympiadServiceImpl implements DataOlympiadService {

    private final static Logger logger = Logger.getLogger(DataOlympiadServiceImpl.class);

    @Autowired
    private DataOlympiadRepository dataOlympiadRepository;

    public List<DataOlympiad> getAllDataOlympiad() {
        return dataOlympiadRepository.findAll();
    }

    public boolean changeDataOlympiadByName(String name, String newData) {
        try {
            DataOlympiad dataOlympiad = dataOlympiadRepository.findByName(name);
            dataOlympiad.setData(newData);
            dataOlympiadRepository.save(dataOlympiad);
            logger.debug("Data about \"" + name + "\" was changed.");
            return true;
        } catch (DataAccessException e) {
            logger.debug("Data about \"" + name + "\" wasn't changed. Cause: " + e.getCause());
            return false;
        }
    }

    @Transactional
    public boolean changeDataOlympiad(DataOlympiad[] dataOlympiads) {
        try {
            for (DataOlympiad data : dataOlympiads) {
                dataOlympiadRepository.save(data);
                logger.debug("Data about \"" + data.getName() + "\" was changed.");
            }
            return true;
        } catch (DataAccessException e) {
            logger.debug("Data olympiad wasn't changed. Cause: " + e.getCause());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

}
