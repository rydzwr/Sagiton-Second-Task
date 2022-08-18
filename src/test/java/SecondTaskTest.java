import com.rydzwr.secondtask.HelloServlet;

import com.rydzwr.secondtask.ParamFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.*;

public class SecondTaskTest
{
    @Test
    @DisplayName("Check printed message")
    public void testServlet() throws Exception
    {
        //GIVEN
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        //WHEN
        when(response.getWriter()).thenReturn(writer);
        new HelloServlet().doGet(request, response);

        //THEN
        assertTrue(stringWriter.toString().contains("Hello"));
    }

    @Test
    @DisplayName("Check printed message with param value")
    public void testServlet2() throws Exception
    {
        //GIVEN
        String foo = "Foo";
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        //WHEN
        when(request.getParameter(anyString())).thenReturn(foo);
        when(response.getWriter()).thenReturn(writer);
        new ParamFilter().doFilter(request, response, filterChain);

        //THEN
        assertTrue(stringWriter.toString().contains(foo + " " + "Hello World!" + " " + foo));
    }
}
