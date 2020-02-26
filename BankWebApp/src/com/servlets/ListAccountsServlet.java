package com.servlets;

//connect 'jdbc:derby://localhost:1527/TrainingDB;create=true';

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Account;
import com.repository.AccountRepository;
import com.repository.AccountRepositoryImp;
import com.repository.exceptions.AccountRepositoryException;

/**
 * Servlet implementation class ListAccountsServlet
 */
@WebServlet("/accounts")
public class ListAccountsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        AccountRepository repository = new AccountRepositoryImp();
        try {
            List<Account> accounts = repository.fetchAllAccounts();
            // storing the collection into the request
            request.setAttribute("listAccounts", accounts);
            // response.sendRedirect("listAccounts.jsp");
            this.getServletContext().getRequestDispatcher("/listAccounts.jsp").forward(request, response);
        } catch (AccountRepositoryException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
