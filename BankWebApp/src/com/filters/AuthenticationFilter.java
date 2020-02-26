package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor.
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
        throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here

        // pass the request along the filter chain

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getServletPath();
        if (!path.equalsIgnoreCase("/login.jsp") && !path.equalsIgnoreCase("/validate")) {
            HttpSession session = httpRequest.getSession();
            Object token = session.getAttribute("AuthToken");
            if (token == null) {

                httpResponse.sendRedirect("login.jsp");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);

        }


    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(final FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
