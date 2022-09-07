package com.rydzwr;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "helloWorld", value = "/hello.world")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        String message = "Hello World!";
        try {
            response.getWriter().print(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}