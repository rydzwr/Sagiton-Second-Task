package com.rydzwr.secondtask;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebFilter(value = "/hello.world", filterName = "MyFilter")
public class ParamFilter implements Filter
{
    private String message;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        message = "Hello World!";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        String param = servletRequest.getParameter("abc");
        if (param != null)
            out.println(param+ " " + message + " " + param);
        else
            filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
