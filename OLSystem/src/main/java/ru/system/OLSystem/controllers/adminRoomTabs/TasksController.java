package ru.system.OLSystem.controllers.adminRoomTabs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.system.OLSystem.data.entity.Task;
import ru.system.OLSystem.data.service.TasksService;

import java.util.Arrays;
import java.util.List;

@RestController
public class TasksController {

    private final static Logger logger = Logger.getLogger(TasksController.class);

    @Autowired
    private TasksService tasksService;

    @RequestMapping(value = "/adminRoom/tasks/getTasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> getAllTasks(){
        logger.trace("Request[/adminRoomTabs/tasks/getTasks] for get all the tasks.");
        return tasksService.getAllTasks();
    }

    @RequestMapping(value = "/adminRoom/tasks/addTask", method = RequestMethod.POST)
    public boolean addNewTask(@RequestBody Task task) {
        logger.trace("Request[/adminRoomTabs/tasks/addTask] for adding task: \"" + task.getTitle() + "\".");
        return tasksService.addNewTask(task.getTitle(), task.getDescription());
    }

    @RequestMapping(value = "/adminRoom/tasks/changeTask", method = RequestMethod.PUT)
    public boolean changeTask(@RequestParam(value = "title") String title,
                              @RequestParam(value = "newTitle") String newTitle,
                              @RequestParam(value = "newDescription") String newDescription) {
        logger.trace("Request[/adminRoomTabs/tasks/changeTask] for changing task: \"" + title + "\".");
        return tasksService.changeTaskByTitle(title, newTitle, newDescription);
    }

    @RequestMapping(value = "/adminRoom/tasks/removeTasks", method = RequestMethod.DELETE)
    public boolean removeTasks(@RequestParam(value = "titles[]") String[] titles) {
        logger.trace("Request[/adminRoomTabs/tasks/removeTasks] for deleting tasks: \"" + Arrays.toString(titles) + "\".");
        return tasksService.removeTasksByTitle(titles);
    }

}
