package ru.system.OLSystem.data.service;

import ru.system.OLSystem.data.entity.Task;

import java.util.List;

public interface TasksService {

    List<Task> getAllTasks();

    boolean removeTasksByTitle(String[] titles);

    boolean addNewTask(String title, String description);

    boolean changeTaskByTitle(String oldTitle, String newTitle, String description);

}
