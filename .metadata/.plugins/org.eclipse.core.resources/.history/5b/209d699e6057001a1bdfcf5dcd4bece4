package com.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        Product product = new Product(100, "IPhone", 80000);
        request.setAttribute("product", product);
        HttpSession session = request.getSession();
        session.setAttribute("name", "Virat Kohli");

        ServletContext context = getServletContext();
        context.setAttribute("appName", "Demo Application");

        request.setAttribute("message", "Hello Request");
        session.setAttribute("message", "Hello Session");
        context.setAttribute("message", "Hello Context");
        context.getRequestDispatcher("/ELView.jsp").forward(request, response);

    }

}
