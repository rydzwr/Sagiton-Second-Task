package com.rydzwr.secondtask;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloWorld", value = "/hello.world")
public class HelloWorld extends HttpServlet
{
    private String message;

    public void init()
    {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        out.println(message);
    }
}