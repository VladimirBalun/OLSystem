package ru.system.OLSystem.olympiad.objects;

import ru.system.OLSystem.data.entity.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participant {

    private String login;
    private int countTruthAnswers;
    private int countTasks;
    private Map<String, TaskDemo> tasksParticipant = new HashMap<>();

    public Participant(String login, List<Task> tasks) {
        loadDemoTasksForParticipant(tasks);
        this.login = login;
        countTruthAnswers = 0;
        countTasks = tasksParticipant.size();
    }

    private void loadDemoTasksForParticipant(List<Task> tasks) {
        for (Task task : tasks) {
            TaskDemo taskDemo = new TaskDemo.Builder()
                    .setTitle(task.getTitle())
                    .setDescription(task.getDescription())
                    .setInputData(task.getTestDataForTask().get(0) == null ? " " : task.getTestDataForTask().get(0).getInput())
                    .setOutputData(task.getTestDataForTask().get(0) == null ? " " : task.getTestDataForTask().get(0).getOutput())
                    .build();
            tasksParticipant.put(taskDemo.getTitle(), taskDemo);
        }
    }

    public void addExecutionTask(String titleTask) {
        tasksParticipant.remove(titleTask);
        countTruthAnswers++;
    }

    public String getLogin() {
        return login;
    }

    public int getCountTruthAnswers() {
        return countTruthAnswers;
    }

    public int getCountTasks() {
        return countTasks;
    }

    public Map<String, TaskDemo> getTasksParticipant() {
        return tasksParticipant;
    }

}