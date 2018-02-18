package ru.tidstu.testingsystem.servlets;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.authentication.RoleUser;
import ru.tidstu.testingsystem.authentication.SignIn;
import ru.tidstu.testingsystem.authentication.SignUp;
import ru.tidstu.testingsystem.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
public class LoginServlet extends DispatcherServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = User.builder()
                .login(req.getParameter("login_sign_up"))
                .password(req.getParameter("pass_sign_up"))
                .name(req.getParameter("name_sign_up"))
                .group(req.getParameter("group_sign_up"))
                .build();
        SignUp signUp = new SignUp();
        if(signUp.register(user)){
            super.forward("/tasks.jsp", req, resp);
        } else {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            String errorMessage = "Пользователь с таким логином уже зарегистрирован.<br/>Придумайте другой.";
            resp.getWriter().write(errorMessage);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login_sign_in");
        String password = req.getParameter("pass_sign_in");
        SignIn signIn = new SignIn();
        RoleUser roleUser = signIn.authenticate(login, password);
        switch (roleUser) {
            case ADMIN:
                super.forward("/admin_room.jsp", req, resp);
                break;
            case USER:
                super.forward("/tasks.jsp", req, resp);
                break;
            case UNKNOWN:
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                String errorMessage = "Не правильно введен логин или пароль.<br/>Пользователь не найден.";
                resp.getWriter().write(errorMessage);
        }
    }

}