package com.servlets;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        if (email.equals("admin") && password.equals("admin")) {
            Cookie emailCookie = new Cookie("email", email);
            Cookie loggedInTimeCookie = new Cookie("loggedInTime", LocalTime.now().toString());
            emailCookie.setMaxAge(100);
            response.addCookie(emailCookie);
            response.addCookie(loggedInTimeCookie);

            HttpSession session = request.getSession();
            String token = LocalTime.now().toString() + " email";
            session.setAttribute("AuthToken", "token");

            response.sendRedirect("welcome.jsp");
        } else {
            // ?key1=abc&key2=xyz
            response.sendRedirect("login.jsp?email=" + email);
        }
    }

};