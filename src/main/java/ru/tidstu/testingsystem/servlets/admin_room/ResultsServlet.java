package ru.tidstu.testingsystem.servlets.admin_room;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.data.service.ResultsService;
import ru.tidstu.testingsystem.utils.SortingResults;
import ru.tidstu.testingsystem.data.entity.Result;
import ru.tidstu.testingsystem.servlets.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j
@WebServlet("/ResultsServlet/*")
public class ResultsServlet extends DispatcherServlet{

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-context.xml");
    private ResultsService resultsService = (ResultsService) appContext.getBean("resultsService");
    private List<Result> resultsOfUsers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String methodSorting = req.getParameter("name_sort");

        if(methodSorting.equals("По ФИО")){
            resultsOfUsers = resultsService.getResultsOfUsers(SortingResults.NAME);
            log.debug("Results of users was sorted by Method: " + methodSorting);
        } else if(methodSorting.equals("По дате проведения")){
            resultsOfUsers = resultsService.getResultsOfUsers(SortingResults.DATE);
            log.debug("Results of users was sorted by Method: " + methodSorting);
        } else {
            resultsOfUsers = resultsService.getResultsOfUsers(SortingResults.RESULT);
            log.debug("Results of users was sorted by Method: " + methodSorting);
        }

        String json = new Gson().toJson(resultsOfUsers);
        resp.getWriter().write(json);
    }

}
