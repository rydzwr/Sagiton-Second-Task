import com.rydzwr.HelloServlet;
import com.rydzwr.ParamFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParamFilterTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    FilterChain filterChain;

    @Test
    @DisplayName("Check printed message with param value")
    public void shouldPrintMessageWithParamValue() throws Exception
    {
        //GIVEN
        String foo = "Foo";
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        //WHEN
        when(request.getParameter(anyString())).thenReturn(foo);
        when(response.getWriter()).thenReturn(writer);

        new ParamFilter().doFilter(request, response, filterChain);

        //THEN
        assertThat(stringWriter.toString().trim(), equalTo(foo + "  " +  foo));
    }
}
