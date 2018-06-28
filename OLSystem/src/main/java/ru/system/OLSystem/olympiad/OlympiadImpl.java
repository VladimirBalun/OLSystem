package ru.system.OLSystem.olympiad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.system.OLSystem.data.service.TasksService;
import ru.system.OLSystem.data.service.TestDataService;
import ru.system.OLSystem.olympiad.objects.Participant;
import ru.system.OLSystem.olympiad.utils.Connector;
import ru.system.OLSystem.olympiad.utils.JsonUtil;

import java.io.IOException;

@Component
public class OlympiadImpl implements Olympiad {

    private static int SUCCESSFUL_CHECKING = 100;
    private static int USER_ERROR = 101;
    private static int SYSTEM_ERROR = 102;
    private static int COMPILATION_ERROR = 103;
    private static int RUN_TIME_ERROR = 105;
    private static int UNKNOWN_ERROR = 105;

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private TasksService tasksService;

    private Participant currentParticipant;

    public void startOlympiad(String login) {
        currentParticipant = new Participant(login, tasksService.getAllTasks());
    }

    public int checkProgram(String titleTask, String textProgram) {
        try {
            String jsonRequest = JsonUtil.generateJsonStructure(titleTask, textProgram, testDataService.getTestDataForTask(titleTask));
            String jsonResponse = Connector.sendTaskOnCkecking(jsonRequest);
            int resultChecking = JsonUtil.getResultCheckingFromJson(jsonResponse);
            if(resultChecking == SUCCESSFUL_CHECKING) {
                currentParticipant.addExecutionTask(titleTask);

            }
            return resultChecking;
        } catch (IOException e) {
            e.printStackTrace();
            return SYSTEM_ERROR;
        }
    }


    public Participant getCurrentParticipant() {
        assert currentParticipant != null;
        return currentParticipant;
    }

    public void finishOlympiad() {

    }

}
