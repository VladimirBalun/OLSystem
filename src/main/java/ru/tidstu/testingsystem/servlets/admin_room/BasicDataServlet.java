package ru.tidstu.testingsystem.servlets.admin_room;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.data.service.BasicDataService;
import ru.tidstu.testingsystem.servlets.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/BasicDataServlet/*")
public class BasicDataServlet extends DispatcherServlet {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-context.xml");
    private BasicDataService basicDataService = (BasicDataService) appContext.getBean("basicDataService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");

        //If request came from form basic_titles
        if(req.getParameter("title_test") != null){
            changeTitles(req);
            resp.getWriter().write("Данные о заголовках системы тестирования успешно изменены.");
            log.debug("Information changes about titles of test.");
        }
        //If request came from form basic_contacts
        if(req.getParameter("name_college") != null){
            changeContacts(req);
            resp.getWriter().write("Данные о контактах учебного заведения успешно изменены.");
            log.debug("Information changes about contacts of test.");
        }
        //If request came from form basic_descriptions
        if(req.getParameter("description_test") != null){
            changeDescriptions(req);
            resp.getWriter().write("Данные о описаниях системы тестирования успешно изменены.");
            log.debug("Information changes about descriptions of test.");
        }
    }

    private void changeTitles(HttpServletRequest req){
        basicDataService.setTitleOfTest(req.getParameter("title_test"));
        basicDataService.setTitleOfResult(req.getParameter("title_result_test"));
    }

    private void changeContacts(HttpServletRequest req){
        basicDataService.setAddress(req.getParameter("address"));
        basicDataService.setPhoneNumber(req.getParameter("phone_number"));
        basicDataService.setNameOfCollege(req.getParameter("name_college"));
    }

    private void changeDescriptions(HttpServletRequest req){
        basicDataService.setDescriptionOfTest(req.getParameter("description_test"));
        basicDataService.setDescriptionOfResult(req.getParameter("description_result_test"));
    }

}