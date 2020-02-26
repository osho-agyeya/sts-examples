package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repository.AccountRepository;
import com.repository.AccountRepositoryImp;
import com.repository.exceptions.AccountRepositoryException;

/**
 * Servlet implementation class DeleteAccountServlet
 */
@WebServlet("/deleteaccount")
public class DeleteAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        AccountRepository repository = new AccountRepositoryImp();

        try {
            repository.removeAccount(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("welcome.jsp");
        } catch (AccountRepositoryException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
