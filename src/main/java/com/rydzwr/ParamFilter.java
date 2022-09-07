package com.rydzwr;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class ParamFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        servletResponse.setContentType("text/html");
        try {
            PrintWriter out = servletResponse.getWriter();
            String param = servletRequest.getParameter("abc");
            if (param != null) {
                out.write(param + " ");
                filterChain.doFilter(servletRequest, servletResponse);
                out.write(" " + param);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}

// TODO: What is context path
