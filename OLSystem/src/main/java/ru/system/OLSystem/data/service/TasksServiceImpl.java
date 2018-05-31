package ru.system.OLSystem.data.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import ru.system.OLSystem.data.entity.Task;
import ru.system.OLSystem.data.dao.TaskRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {

    private final static Logger logger = Logger.getLogger(TasksServiceImpl.class);

    @Autowired
    private TaskRepository taskRepository;

    /**
     *
     * @return
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     *
     * @param titles
     * @return
     */
    @Transactional
    public boolean removeTasksByTitle(String[] titles) {
        try {
            for (String title : titles) {
                if(!taskRepository.existsByTitle(title)){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
                taskRepository.deleteByTitle(title);
                logger.debug("Task \"" + title + "\" was deleted.");
            }
            return true;
        } catch (DataAccessException e) {
            logger.debug("Task \"" + Arrays.toString(titles) + "\" wasn't deleted. Cause: " + e.getCause());
            return false;
        }
    }

    /**
     *
     * @param title
     * @param description
     * @return
     */
    public boolean addNewTask(String title, String description) {
        try {
            Task task = new Task(title, description);
            taskRepository.saveAndFlush(task);
            logger.debug("Task \"" + title + "\" was added.");
            return true;
        } catch (DataAccessException e) {
            logger.debug("Task \"" + title + "\" wasn't added. Cause: " + e.getCause());
            return false;
        }
    }

    /**
     *
     * @param oldTitle
     * @param newTitle
     * @param newDescription
     * @return
     */
    public boolean changeTaskByTitle(String oldTitle, String newTitle, String newDescription) {
        try {
            Task task = taskRepository.findByTitle(oldTitle);
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            taskRepository.save(task);
            logger.debug("Task \"" + oldTitle + "\" was changed.");
            return true;
        } catch (DataAccessException e) {
            logger.debug("Task \"" + oldTitle + "\" wasn't changed. Cause: " + e.getCause());
            return false;
        }
    }

}
