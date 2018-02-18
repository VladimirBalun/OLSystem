package ru.tidstu.testingsystem.servlets.admin_room;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.domain.User;
import ru.tidstu.testingsystem.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j
@WebServlet("/UsersServlet/*")
public class UsersServlet extends HttpServlet {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private UsersService usersService = (UsersService) appContext.getBean("usersService");
    private List<User> users;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        //If request from form del_user
        if(req.getParameter("name_user_for_del") != null){
            delUser(req);
            sendResponse(resp);
        }

        //If request from form select_users
        if(req.getParameter("group_for_select_users") != null){
            selectUsersFromGroup(req);
            sendResponse(resp);
        }
    }

    private void delUser(HttpServletRequest req){
        String nameUser = req.getParameter("name_user_for_del");
        usersService.delUser(nameUser);
        log.debug("User " + nameUser + " was deleted.");
        //Load reloading list users for send on client
        users = usersService.getUsers();
    }

    private void selectUsersFromGroup(HttpServletRequest req){
        String nameGroup = req.getParameter("group_for_select_users");
        log.debug("Users was selected by group " + nameGroup + ".");
        //Load reloading list users for send on client
        users = usersService.getUsersFromGroup(nameGroup);
    }

    private void sendResponse(HttpServletResponse resp) throws IOException {
        String json = new Gson().toJson(users);
        resp.getWriter().write(json);
    }

}