/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipemcoelho.filters;

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

@WebFilter(filterName = "Faces Servlet", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("com.filipemcoelho.filters.AuthenticationFilter.doFilter() doing filter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        // Allow the following pages public else block (if user not logged in
        if (session.getAttribute("loggedInUser") != null
                || (req.getRequestURI().endsWith("index.xhtml"))
                || (req.getRequestURI().endsWith("filterlogin.xhtml"))
                || (req.getRequestURI().endsWith("ourproducts.xhtml"))
                || (req.getRequestURI().endsWith("ourteam.xhtml"))
                || (req.getRequestURI().endsWith("login.xhtml"))
                || (req.getRequestURI().endsWith("error.xhtml"))
                || (req.getRequestURI().contains("javax.faces.resource/"))) {

            chain.doFilter(request, response);

        } else {
            redirect("filterlogin.xhtml", response);
        }
        
        //chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void redirect(String url, ServletResponse response) throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);

    }

}
