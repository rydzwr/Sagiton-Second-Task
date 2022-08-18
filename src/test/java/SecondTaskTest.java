import com.rydzwr.secondtask.FooFilter;
import com.rydzwr.secondtask.HelloServlet;

import com.rydzwr.secondtask.ParamFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.*;

public class SecondTaskTest {
    @Test
    @DisplayName("Check printed message")
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new HelloServlet().doGet(request, response);

        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("Hello"));
    }

    @Test
    @DisplayName("Check printed message with param value")
    public void testServlet2() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        when(request.getParameter(anyString())).thenReturn("Foo");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new ParamFilter().doFilter(request, response, filterChain);

        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("Foo" + " " + "Hello World!" + " " + "Foo"));
    }
}
