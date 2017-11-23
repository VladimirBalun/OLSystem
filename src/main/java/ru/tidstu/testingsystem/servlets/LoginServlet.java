package ru.tidstu.testingsystem.servlets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.tidstu.testingsystem.models.FactoryModels;
import ru.tidstu.testingsystem.models.FirebirdDB;
import ru.tidstu.testingsystem.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Balun Vladimir
 */
public class LoginServlet extends DispatcherServlet {


    private final static Logger log = LogManager.getLogger(LoginServlet.class);

    /**
     * Common data of user.
     */
    private String login;
    private String password;
    private String name;
    private String group;

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login_sign_up");
        password = req.getParameter("pass_sign_up");
        name = req.getParameter("name_sign_up");
        group = req.getParameter("group_sign_up");

        if(login == "" || password == "" || name == "" || group == ""){
            return;
        }

        String query = "INSERT INTO users(login, password, full_name, id_group) VALUES('" + login + "','" + password + "','" + name + "',(SELECT g.id FROM groups g WHERE g.name_group = '" + group + "'))";
        FirebirdDB.getInstance().execInsert(query);
        super.forward("/tasks.jsp", req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login_sign_in");
        password = req.getParameter("pass_sign_in");

        if(login == "" || password == ""){
            return;
        }

        String query = "SELECT u.login, u.password, u.full_name, g.name_group FROM users u LEFT JOIN groups g ON u.id_group = g.id WHERE login = '" + login + "'";
        User user = FactoryModels.getUser(query);

        log.debug(user.toString());
        super.forward("/tasks.jsp", req, resp);
    }

}
