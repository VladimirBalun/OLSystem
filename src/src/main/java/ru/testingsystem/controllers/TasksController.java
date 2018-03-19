package ru.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.testingsystem.data.entity.Log;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.olympiad.Olympiad;

import java.util.List;
import java.util.Queue;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private Olympiad olympiad;

    @RequestMapping(value = "/selectedTask", method = RequestMethod.GET)
    public @ResponseBody Question showSelectedTask(@RequestParam(value = "name_selected_question") String nameQuestion){
        return olympiad.getQuestion(nameQuestion);
    }

    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public ModelAndView showPageTasks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questions", olympiad.getQuestions());
        modelAndView.addObject("logs", olympiad.getLogsOfRunningTest());
        modelAndView.addObject("statisticUser", olympiad.getStatisticUser());
        modelAndView.setViewName("tasks");
        return modelAndView;
    }

    @RequestMapping(value = "/checkTask", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String checkTask(@RequestParam(value = "name_question") String nameQuestion, @RequestParam(value = "text_program") String txtProgram){
        return olympiad.checkTask(nameQuestion, txtProgram);
    }

    @RequestMapping(value = "/reloadLogs", method = RequestMethod.GET)
    public @ResponseBody Queue<Log> reloadLogsRunningOlympiad(){
        return olympiad.getLogsOfRunningTest();
    }

    @RequestMapping(value = "/reloadQuestions", method = RequestMethod.GET)
    public @ResponseBody List<Question> reloadQuestionsOlympiad(){
        return olympiad.getQuestions();
    }

    @RequestMapping(value = "/reloadStatistic", method = RequestMethod.GET)
    public @ResponseBody String reloadUserStatisticOlympiad(){
        return olympiad.getStatisticUser();
    }

}
