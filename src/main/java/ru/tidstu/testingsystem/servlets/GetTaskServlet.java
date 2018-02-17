package ru.tidstu.testingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetTaskServlet extends DispatcherServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String nameQuestion = req.getParameter("name_question");
        String txtProgramm = req.getParameter("text_program");
        PrintWriter out = resp.getWriter();
        out.println("Началась обработка программы...");
    }

}
