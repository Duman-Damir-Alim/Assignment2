package assignment1;

import javax.servlet.*;
import java.io.IOException;

public class PrimaryFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("It will open when any servlet opens");
        servletResponse.getWriter().write("Any Servlet");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("It will be closed after all servlets close");
    }
}
