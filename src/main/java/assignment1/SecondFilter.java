package assignment1;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Opening second Filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Closing second Filter");
    }
}
