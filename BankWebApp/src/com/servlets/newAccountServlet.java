package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Account;
import com.repository.AccountRepository;
import com.repository.AccountRepositoryImp;
import com.repository.exceptions.AccountRepositoryException;

@WebServlet("/newaccount")
public class newAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public newAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {

        AccountRepository repository = new AccountRepositoryImp();
        try {
            String fullName = request.getParameter("fullName");
            double balance = Double.parseDouble(request.getParameter("balance"));
            Account newAccount = new Account(0, fullName, balance);
            repository.saveAccount(newAccount);
            response.sendRedirect("welcome.jsp");
        } catch (AccountRepositoryException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
