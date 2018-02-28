package ru.tidstu.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.utils.Olympiad;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private Olympiad olympiad;

    @RequestMapping(value = "/selectedTask", method = RequestMethod.GET)
    public @ResponseBody Question changeSelectedTask(@RequestParam(value = "number_question") int numberQuestion){
        Question selectedQuestion = olympiad.getQuestion(numberQuestion);
        return Question.builder()
                .title(selectedQuestion.getTitle())
                .text(selectedQuestion.getText())
                .inputData(selectedQuestion.getInputData())
                .outputData(selectedQuestion.getOutputData())
                .build();
    }

    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public ModelAndView showPageTasks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questions", olympiad.getQuestions());
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
