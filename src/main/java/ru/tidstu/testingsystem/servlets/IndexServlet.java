package ru.tidstu.testingsystem.servlets;

import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
public class IndexServlet extends DispatcherServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UsersService userMaker = new UsersService();
//        User user = userMaker.getCurrentUser();
//        log.debug(user.toString());

//        if(user.getLogin() == null){
            super.forward("/login.jsp", req, resp);
//        } else {
//            super.forward("/tasks.jsp", req, resp);
//        }

    }
}
