package ru.testingsystem.controllers.admin_room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.testingsystem.data.entity.Question;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionsController extends AdminRoomController{

    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
    public @ResponseBody
    Question showQuestion(@RequestParam(value = "name_question") String nameQuestion){
        System.out.println(nameQuestion);
        return questionsService.getQuestion(nameQuestion);
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public @ResponseBody List<Question> addQuestion(@RequestParam(value = "title_question_for_add") String titleQuestion,
                                                    @RequestParam(value = "text_question_for_add") String textQuestion){
        questionsService.addQuestion(titleQuestion, textQuestion);
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/addTestData", method = RequestMethod.POST)
    public @ResponseBody List<Question> addTestDataForQuestion(@RequestParam(value = "name_question_for_add") String nameQuestion,
                                                               @RequestParam(value = "input_data") String testInputData,
                                                               @RequestParam(value = "output_data") String testOutputData){
        testDataService.addTestDataForQuestion(nameQuestion, testInputData, testOutputData);
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/changeQuestion", method = RequestMethod.POST)
    public @ResponseBody List<Question> changeQuestion(@RequestParam(value = "name_question_for_change") String oldTitleQuestion,
                                                       @RequestParam(value = "title_question_for_change") String newTitleQuestion,
                                                       @RequestParam(value = "text_question_for_change") String newTextQuestions){
        questionsService.changeQuestion(oldTitleQuestion, newTitleQuestion, newTextQuestions);
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/delQuestion", method = RequestMethod.POST)
    public @ResponseBody List<Question> removeQuestion(@RequestParam(value = "name_question_for_del") String nameQuestion){
        questionsService.removeQuestion(nameQuestion);
        return questionsService.getQuestions();
    }

}
