
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("HelloServlet.destroy()");
    }

    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        System.out.println("HelloServlet.getServletConfig()");
        return null;
    }

    public String getServletInfo() {
        // TODO Auto-generated method stub
        System.out.println("HelloServlet.getServletInfo()");
        return null;
    }

    public void init(final ServletConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("HelloServlet.init()");

    }

    public void service(final ServletRequest request, final ServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("HelloServlet.service()");
        // mime types (xml=text/xml jpg=img/jpg)
        response.setContentType("text/html");
        // input stream and output stream are for bytes
        // file reader and writer are for characters
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h2>Hello Servlet</h2>");
        out.println("<p>Generated at " + new Date().toString() + "</p>");
        out.println("</body>");
        out.println("</html>");


    }

}
