import com.rydzwr.FooFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class FooFilterTest {

    @Mock
    private HttpServletResponse response;

    @Test
    public void shouldThrow401WhenUnauthorized() throws IOException {
        new FooFilter().doFilter(null, response, null);

        Mockito.verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
    }
}
