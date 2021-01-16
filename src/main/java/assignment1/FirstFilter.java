package assignment1;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Opening first Filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Closing first Filter");
    }
}
