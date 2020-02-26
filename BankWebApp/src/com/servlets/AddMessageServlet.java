package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddMessageServlet
 */
@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        String message = request.getParameter("message");
        HttpSession session = request.getSession();
        List<String> messages = (List<String>) session.getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
        }

        // List<String> messages = new ArrayList<>();
        messages.add(message);
        session.setAttribute("messages", messages);

        String globalMessage = request.getParameter("global_msg");
        if (globalMessage != null & !globalMessage.isEmpty()) {
            ServletContext context = getServletContext();
            context.setAttribute("global", globalMessage);
        }
        response.getWriter().println("Message received as:" + message);

    }

}
