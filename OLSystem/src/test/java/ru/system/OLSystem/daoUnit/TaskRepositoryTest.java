package ru.system.OLSystem.daoUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.system.OLSystem.configuration.DataConfig;
import ru.system.OLSystem.data.entity.Task;
import ru.system.OLSystem.data.dao.TaskRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Rollback
    @Transactional
    public void addingNewTask() {
        Task task = new Task("title", "description");
        taskRepository.saveAndFlush(task);
        boolean isExistTask = taskRepository.existsByTitle("title");
        Assert.assertTrue(isExistTask);
    }

    @Rollback
    @Transactional
    @Test(expected = DataAccessException.class)
    public void addingNewTasksWithEqualTitle() {
        Task task1 = new Task("title", "description_1");
        Task task2 = new Task("title", "description_2");
        taskRepository.saveAndFlush(task1);
        taskRepository.saveAndFlush(task2);
    }

    @Rollback
    @Transactional
    @Test(expected = DataAccessException.class)
    public void addingNewTaskWithOverflowTitle() {
        Task task = new Task("count_letters_more_20", "description");
        taskRepository.saveAndFlush(task);
    }

    @Test
    @Rollback
    @Transactional
    public void changingTask() {
        Task newTask = new Task("title", "description");
        taskRepository.saveAndFlush(newTask);
        Task taskFromBD = taskRepository.findByTitle("title");
        taskFromBD.setTitle("newTitle");
        taskFromBD.setDescription("newDescription");
        taskRepository.save(taskFromBD);
        Task reloadingTask = taskRepository.findByTitle("newTitle");
        Assert.assertEquals("newDescription", reloadingTask.getDescription());
    }

    @Test
    @Rollback
    @Transactional
    public void deletingTask() {
        Task task = new Task("title", "description");
        taskRepository.saveAndFlush(task);
        taskRepository.deleteByTitle("title");
        boolean isExistTask = taskRepository.existsByTitle("title");
        Assert.assertFalse( isExistTask);
    }

}
