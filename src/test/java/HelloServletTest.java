import com.rydzwr.HelloServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.*;

public class HelloServletTest
{
    @Test
    @DisplayName("Check printed message")
    public void helloServletTest() throws Exception
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
}
