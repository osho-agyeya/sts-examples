package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/productsearch")
public class ProductSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        String psearch = request.getParameter("psearch");
        ProductService service = new ProductServiceImpl();
        Product product = service.seachProduct(psearch);
        request.setAttribute("prd", product);
        // to go to jsp, we can do redirect or dispatcher forward
        this.getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);


    }

}
