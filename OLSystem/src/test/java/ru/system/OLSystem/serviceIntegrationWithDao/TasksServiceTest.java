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
import ru.system.OLSystem.data.service.TasksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class TasksServiceTest {

    @Autowired
    private TasksService tasksService;

    @Test
    @Rollback
    @Transactional
    public void addingNewTask() {
        boolean isAdding = tasksService.addNewTask("title", "description");
        Assert.assertEquals(true, isAdding);
    }

    @Test
    @Rollback
    @Transactional
    public void changingTask() {
        boolean isAdding = tasksService.addNewTask("title", "description");
        Assert.assertTrue(isAdding);
        boolean isChanging = tasksService.changeTaskByTitle("title", "new_title", "new_description");
        Assert.assertTrue(isChanging);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingOneTask() {
        boolean isAdding = tasksService.addNewTask("title", "description");
        Assert.assertTrue(isAdding);
        String[] tasks = { "title" };
        boolean isDeleting = tasksService.removeTasksByTitle(tasks);
        Assert.assertTrue(isDeleting);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingNonExistentTask() {
        String[] tasks = { "undefined_task" };
        boolean isDeleting = tasksService.removeTasksByTitle(tasks);
        Assert.assertFalse(isDeleting);
    }

    @Test
    @Rollback
    @Transactional
    public void deletingExistentAndNonExistentTasks() {
        boolean isAdding = tasksService.addNewTask("title", "description");
        Assert.assertTrue(isAdding);
        String[] tasks = { "title", "undefined_task" };
        boolean isDeleting = tasksService.removeTasksByTitle(tasks);
        Assert.assertFalse(isDeleting);
    }

}