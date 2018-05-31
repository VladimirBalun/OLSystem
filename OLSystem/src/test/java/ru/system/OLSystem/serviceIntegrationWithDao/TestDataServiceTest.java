package ru.system.OLSystem.serviceIntegrationWithDao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.system.OLSystem.configuration.DataConfig;
import ru.system.OLSystem.data.dao.TaskRepository;
import ru.system.OLSystem.data.entity.Task;
import ru.system.OLSystem.data.service.TestDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class TestDataServiceTest {

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Rollback
    @Transactional
    public void addingTestDataForTask() {
        Task task = new Task("title", "description");
        taskRepository.saveAndFlush(task);
        boolean isAdding = testDataService.addNewTestDataForTask("title", "input", "output");
        Assert.assertTrue(isAdding);
    }

}
