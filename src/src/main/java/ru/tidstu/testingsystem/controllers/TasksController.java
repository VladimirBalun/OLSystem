package ru.tidstu.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.olympiad.Olympiad;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private Olympiad olympiad;

    @RequestMapping(value = "/selectedTask", method = RequestMethod.GET)
    public @ResponseBody Question showSelectedTask(@RequestParam(value = "number_question") String numberQuestion){
        return olympiad.getQuestion(Integer.parseInt(numberQuestion));
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
        switch (olympiad.checkTask(nameQuestion, txtProgram)){
            case ERROR_COMPILATION:
                return "Ошибка компиляции";
            case LOGIC_ERROR_IN_PROGRAM:
                return "Ошибка в результате программы";
            case SUCCESS:
                return "Задание выполнено";
        }
        return "Неизвестная ошибка";
    }

}
