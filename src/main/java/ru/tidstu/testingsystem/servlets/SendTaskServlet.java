package ru.tidstu.testingsystem.servlets;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.data.entity.Log;
import ru.tidstu.testingsystem.data.entity.TestData;
import ru.tidstu.testingsystem.data.service.TestDataService;
import ru.tidstu.testingsystem.utils.Olympiad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Log4j
@WebServlet("/SendTaskServlet/*")
public class SendTaskServlet extends DispatcherServlet{

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private TestDataService testDataService = (TestDataService) appContext.getBean("testDataService");
    private Olympiad olympiad = (Olympiad) appContext.getBean("olympiad");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String titleQuestion = req.getParameter("name_question");
        String txtProgram = req.getParameter("text_program");
        List<TestData> testData = testDataService.getTestDataForQuestion(titleQuestion);
        log.info("IsEmpty : " + testData.isEmpty());
        PrintWriter out = resp.getWriter();
        Log log;
        switch (olympiad.checkTask(txtProgram, testData)){
            case ERROR_COMPILATION:
                log = new Log(getCurrentTime(), "Ошибка компиляции");
                olympiad.addLog(log);
                out.println("Ошибка компиляции");
                break;
            case LOGIC_ERROR_IN_PROGRAM:
                log = new Log(getCurrentTime(), "Ошибка в результате программы");
                olympiad.addLog(log);
                out.println("Ошибка в результате программы");
                break;
            case SUCCESS:
                log = new Log(getCurrentTime(), "Задание выполнено");
                olympiad.addLog(log);
                olympiad.delQuestion(titleQuestion);
                out.println("Задание выполнено");
                break;
        }
    }

    private String getCurrentTime() {
        GregorianCalendar gcalendar = new GregorianCalendar();
        String curTime = gcalendar.get(Calendar.HOUR) + ":" +
                gcalendar.get(Calendar.MINUTE) + ":" +
                gcalendar.get(Calendar.SECOND);
        return curTime;
    }
}
