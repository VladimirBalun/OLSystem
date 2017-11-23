package ru.tidstu.testingsystem.servlets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Balun Vladimir
 */
public class DispatcherServlet extends HttpServlet {

    private final static Logger log = LogManager.getLogger(DispatcherServlet.class);

    /**
     *
     * @param toPage path of page for forward
     * @param req request for forward
     * @param resp response for forward
     * @throws ServletException
     * @throws IOException
     */
    public void forward(String toPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(toPage);
        requestDispatcher.forward(req, resp);
        log.info("Forward to " + toPage);
    }

}
