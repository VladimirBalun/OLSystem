package ru.tidstu.testingsystem.servlets.admin_room;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.services.GroupsService;
import ru.tidstu.testingsystem.services.models.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j
@WebServlet("/GroupsServlet/*")
public class GroupsServlet extends HttpServlet {

    private GroupsService groupsService = new GroupsService();
    private List<Group> groups;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        //If request from form add_group
        if(req.getParameter("title_group") != null){
            addGroup(req);
            sendResponse(resp);
        }
        //If request from form change_group
        if(req.getParameter("old_title_group") != null){
            changeGroup(req);
            sendResponse(resp);
        }
        //If request from form del_group
        if(req.getParameter("title_group_del") != null){
            deleteGroup(req);
            sendResponse(resp);
        }
    }

    private void addGroup(HttpServletRequest req) {
        String nameGroup = req.getParameter("title_group");
        groupsService.addGroup(nameGroup);
        log.debug("Group " + nameGroup + " was added.");
    }

    private void changeGroup(HttpServletRequest req) {
        String oldNameGroup = req.getParameter("old_title_group");
        String newNameGroup = req.getParameter("new_title_group");
        groupsService.changeGroup(oldNameGroup, newNameGroup);
        log.debug("Group " + oldNameGroup + " was changed on " + newNameGroup + ".");
    }

    private void deleteGroup(HttpServletRequest req) {
        String nameGroup = req.getParameter("title_group_del");
        groupsService.deleteGroup(nameGroup);
        log.debug("Group " + nameGroup + " was deleted.");
    }

    private void sendResponse(HttpServletResponse resp) throws IOException {
        groups = groupsService.getGroups();
        String json = new Gson().toJson(groups);
        resp.getWriter().write(json);
    }

}