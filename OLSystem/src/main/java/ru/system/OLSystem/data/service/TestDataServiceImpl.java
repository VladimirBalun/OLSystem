package ru.system.OLSystem.data.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.system.OLSystem.data.dao.TaskRepository;
import ru.system.OLSystem.data.entity.Task;
import ru.system.OLSystem.data.entity.TestData;
import ru.system.OLSystem.data.dao.TestDataRepository;

import java.util.List;

@Service
public class TestDataServiceImpl implements TestDataService {

    private final static Logger logger = Logger.getLogger(TestDataService.class);

    @Autowired
    private TestDataRepository testDataRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<TestData> getAllTestData() {
        return testDataRepository.findAll();
    }

    public List<TestData> getTestDataForTask(String titleTask) {
        Task task = taskRepository.findByTitle(titleTask);
        return testDataRepository.findByTask(task);
    }

    public boolean addNewTestDataForTask(String titleTask, String inputData, String outputData) {
        try {
            Task task = taskRepository.findByTitle(titleTask);
            TestData newTestDataForTask = new TestData("input", "output", task);
            testDataRepository.saveAndFlush(newTestDataForTask);
            logger.debug("Test data for task \"" + titleTask + "\" was added.");
            return true;
        } catch (DataAccessException e) {
            logger.debug("Test data for task \"" + titleTask + "\" wasn't added. Cause: " + e.getCause());
            return false;
        }
    }

    public boolean removeTestDataByInoutAndOutputData(String inputData, String outputData) {
        return false;
    }

}
