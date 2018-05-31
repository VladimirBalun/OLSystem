package ru.system.OLSystem.controllers.adminRoomTabs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.system.OLSystem.data.entity.TestData;
import ru.system.OLSystem.data.service.TestDataService;

import java.util.List;

@RestController
public class TestDataController {

    private final static Logger logger = Logger.getLogger(TestDataController.class);

    @Autowired
    private TestDataService testDataService;

    @RequestMapping(value = "/adminRoom/testData/getTestData", method = RequestMethod.GET)
    public List<TestData> getAllTestDataTasks(){
        logger.trace("Request[/adminRoom/testData/getTestData] for get all the test data of tasks.");
        return testDataService.getAllTestData();
    }

    @RequestMapping(value = "/adminRoom/results/addTestData", method = RequestMethod.POST)
    public boolean addTestDataTask(@RequestBody TestData testData){
        logger.trace("Request[/adminRoom/results/addTestData] for add test data for task.");
        return testDataService.addNewTestDataForTask(testData.getTask().getTitle(), testData.getInput(), testData.getOutput());
    }

    @RequestMapping(value = "/adminRoom/results/removeTestData", method = RequestMethod.DELETE)
    public boolean removeTestDataTask(@RequestBody TestData[] testData){
        logger.trace("Request[/adminRoom/results/removeTestData] for delete test data of task.");
        for (TestData data : testData) {
            System.out.println(data.getTask().getTitle() + " - " + data.getInput() + " - " + data.getOutput());
        }
        return true;
    }

}
