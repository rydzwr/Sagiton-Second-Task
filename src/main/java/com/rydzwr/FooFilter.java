package com.rydzwr;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(value = "/foo.world", filterName = "FooFilter")
public class FooFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        try {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
