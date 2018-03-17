package ru.testingsystem.aspect;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j
@Aspect
@Component
public class LoggingQuestionService {

    @AfterReturning(pointcut = "execution(* ru.testingsystem.data.service.QuestionsService.addQuestion(title, text))",
            returning= "resultAdding", argNames = "resultAdding, title, text")
    public void logAddingQuestion(boolean resultAdding, String title, String text){
        if (resultAdding){
            log.debug("Question [" + title + "] was added.");
        } else {
            log.debug("Question [" + title + "] wasn't added. Unknown error.");
        }
    }

    @AfterReturning(pointcut = "execution(* ru.testingsystem.data.service.QuestionsService.removeQuestion(title))",
            returning= "resultDeleting", argNames = "resultDeleting, title")
    public void logRemovingQuestion(boolean resultDeleting, String title){
        if (resultDeleting){
            log.debug("Question [" + title + "] was deleted.");
        } else {
            log.debug("Question [" + title + "] wasn't deleted. This Question not found.");
        }
    }

    @AfterReturning(pointcut = "execution(* ru.testingsystem.data.service.QuestionsService.changeQuestion(oldTitle, newTitle, newText))",
            returning= "resultChanging", argNames = "resultChanging, oldTitle, newTitle, newText")
    public void logRemovingQuestion(boolean resultChanging, String oldTitle, String newTitle, String newText){
        if (resultChanging){
            log.debug("Question [" + oldTitle + "] was changed on title=[" + newTitle + "] and text=[" + newText + "].");
        } else {
            log.debug("Question [" + oldTitle + "] wasn't changed. This question not found.");
        }
    }

}