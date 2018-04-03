package ru.testingsystem.controllers.adminRoom;

import org.springframework.web.bind.annotation.*;
import ru.testingsystem.data.entity.Question;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController extends AdminRoomController{

    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
    public Question showQuestion(@RequestParam(value = "name_question") String nameQuestion){
        return questionsService.getQuestionByTitle(nameQuestion);
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public List<Question> addQuestion(@RequestParam(value = "title_question_for_add") String titleQuestion,
                                      @RequestParam(value = "text_question_for_add") String textQuestion){
        questionsService.addQuestion(titleQuestion, textQuestion);
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/addTestData", method = RequestMethod.POST)
    public List<Question> addTestDataForQuestion(@RequestParam(value = "name_question_for_add") String nameQuestion,
                                                 @RequestParam(value = "input_data") String testInputData,
                                                 @RequestParam(value = "output_data") String testOutputData){
        testDataService.addTestDataForQuestion(nameQuestion, testInputData, testOutputData);
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/changeQuestion", method = RequestMethod.POST)
    public List<Question> changeQuestion(@RequestParam(value = "name_question_for_change") String oldTitleQuestion,
                                         @RequestParam(value = "title_question_for_change") String newTitleQuestion,
                                         @RequestParam(value = "text_question_for_change") String newTextQuestions){
        questionsService.changeQuestion(oldTitleQuestion, newTitleQuestion, newTextQuestions);
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/delQuestion", method = RequestMethod.POST)
    public List<Question> removeQuestion(@RequestParam(value = "name_question_for_del") String nameQuestion){
        questionsService.removeQuestion(nameQuestion);
        return questionsService.getQuestions();
    }

}
