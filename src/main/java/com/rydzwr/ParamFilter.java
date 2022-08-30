package com.rydzwr;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(value = "/hello.world", filterName = "MyFilter")
public class ParamFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    {
        servletResponse.setContentType("text/html");
        try
        {
            PrintWriter out = servletResponse.getWriter();
            String param = servletRequest.getParameter("abc");
            String message = "Hello World!";
            if (param != null)
                out.println(param+ " " + message + " " + param);
            else
                filterChain.doFilter(servletRequest, servletResponse);
        }
        catch (IOException | ServletException e)
        {
            e.printStackTrace();
        }
    }
}
