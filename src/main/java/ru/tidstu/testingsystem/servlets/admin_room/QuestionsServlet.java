package ru.tidstu.testingsystem.servlets.admin_room;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.data.service.QuestionsService;
import ru.tidstu.testingsystem.data.service.TestDataService;
import ru.tidstu.testingsystem.servlets.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/QuestionsServlet/*")
public class QuestionsServlet extends DispatcherServlet {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private QuestionsService questionsService = (QuestionsService) appContext.getBean("questionsService");
    private TestDataService testDataService =  (TestDataService) appContext.getBean("testDataService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String nameQuestion = req.getParameter("nameQuestion").trim();
        log.debug("Request came for show question '" + nameQuestion + "' in admin room");
        Question question = questionsService.getQuestion(nameQuestion);
        String json = new Gson().toJson(question);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        //If request from form add_question
        if(req.getParameter("title_question_for_add") != null){
            addQuestion(req);
        }
        //If request from form del_question
        if(req.getParameter("name_question_for_del") != null){
            delQuestion(req);
        }
        //If request from form add_data_of_question
        if(req.getParameter("input_data") != null){
            addTestDataForQuestion(req);
        }
        //If request from form change_question
        if(req.getParameter("title_question_for_change") != null){
            changeQuestion(req);
        }
        String json = new Gson().toJson(questionsService.getAllQuestions());
        resp.getWriter().write(json);
    }

    private void addQuestion(HttpServletRequest req){
        Question question = Question.builder().
                title(req.getParameter("title_question_for_add")).
                text(req.getParameter("text_question_for_add")).
                number(0).
                build();
        questionsService.addQuestion(question);
        log.debug("Question " + question.getTitle() + " was added.");
    }

    private void delQuestion(HttpServletRequest req){
        String titleQuestion = req.getParameter("name_question_for_del");
        questionsService.removeQuestion(titleQuestion);
        log.debug("Question " + titleQuestion + " was deleteded.");
    }

    private void addTestDataForQuestion(HttpServletRequest req){
        String nameQuestion = req.getParameter("name_question_for_add");
        String inputData = req.getParameter("input_data");
        String outputData = req.getParameter("output_data");
        testDataService.addTestDataForQuestion(nameQuestion, inputData, outputData);
        log.debug("Test data was added for question " + nameQuestion);
    }

    private void changeQuestion(HttpServletRequest req){
        String newTitle = req.getParameter("title_question_for_change");
        String newText = req.getParameter("text_question_for_change");
        String nameQuestion = req.getParameter("name_question_for_change");
        questionsService.changeQuestion(nameQuestion, newTitle, newText);
        log.debug("Question " + newTitle + " was changed.");
    }

}