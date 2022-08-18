package com.rydzwr.secondtask;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(value = "/foo.world", filterName = "FooFilter")
public class FooFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    {
       // throw new RuntimeException("Exception has been thrown!");
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        try
        {
            resp.sendError(401, "Authentication failed");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
