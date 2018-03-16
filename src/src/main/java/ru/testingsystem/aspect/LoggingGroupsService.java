package ru.testingsystem.aspect;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j
@Aspect
@Component
public class LoggingGroupsService {

    @AfterReturning(pointcut = "execution(* ru.testingsystem.data.service.GroupsService.addGroup(nameGroup))",
                    returning= "resultAdding", argNames = "resultAdding, nameGroup")
    public void logAddingGroup(boolean resultAdding, String nameGroup){
        if (resultAdding){
            log.debug("Group [" + nameGroup + "] was added.");
        } else {
            log.debug("Group [" + nameGroup + "] wasn't added. This group is exist.");
        }
    }

    @AfterReturning(pointcut = "execution(* ru.testingsystem.data.service.GroupsService.changeNameGroup(newName, oldName))",
            returning= "resultChanging", argNames = "resultChanging, newName, oldName")
    public void logChangingGroup(boolean resultChanging, String newName, String oldName){
        if (resultChanging){
            log.debug("Name of group [" + oldName + "] was changed on " + newName + "].");
        } else {
            log.debug("Name of group [" + oldName + "] wasn't changed. Group [" + oldName + "] " +
                      "not found or new name of group [" + newName + "] already exist");
        }
    }

    @AfterReturning(pointcut = "execution(* ru.testingsystem.data.service.GroupsService.removeGroup(nameGroup))",
            returning= "resultRemoving", argNames = "resultRemoving, nameGroup")
    public void logRemovingGroup(boolean resultRemoving, String nameGroup){
        if (resultRemoving){
            log.debug("Group " + nameGroup + " was deleted.");
        } else {
            log.debug("Group " + nameGroup + " wasn't deleted. This group not found.");
        }
    }

}
