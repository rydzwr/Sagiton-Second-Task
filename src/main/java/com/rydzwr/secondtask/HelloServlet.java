package com.rydzwr.secondtask;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloWorld", value = "/hello.world")
public class HelloServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        String message = "Hello World!";
        try
        {
            response.getWriter().println(message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}