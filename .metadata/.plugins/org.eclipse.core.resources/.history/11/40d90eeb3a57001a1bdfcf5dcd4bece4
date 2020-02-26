package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CustomDate;
import com.repository.DateCalculator;

@WebServlet("/datecalculate")
public class DateCalculateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DateCalculateServlet() {
        super();
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        try {
            String myDate = request.getParameter("myDate");
            int addMonth = Integer.parseInt(request.getParameter("addMonth"));
            int addYear = Integer.parseInt(request.getParameter("addYear"));
            String arr[] = myDate.split("-");
            CustomDate initialDate = new CustomDate(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
            DateCalculator dateCalculator = new DateCalculator();
            CustomDate newDate = dateCalculator.calculateDate(initialDate, addMonth, addYear);
            request.setAttribute("newdate", newDate);
            // to go to jsp, we can do redirect or dispatcher forward
            this.getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
