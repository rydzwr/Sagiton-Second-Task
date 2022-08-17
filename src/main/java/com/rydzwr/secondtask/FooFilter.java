package com.rydzwr.secondtask;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(value = "/foo.world", filterName = "FooFilter")
public class FooFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException
    {
       // throw new RuntimeException("Exception has been thrown!");
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.sendError(401, "Authentication failed");
    }

    @Override
    public void destroy() {}
}
