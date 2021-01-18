package assignment2.Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
//        chain.doFilter(req, resp);
//        if (uri.endsWith("chess_table.js") || uri.endsWith("main.js") || uri.endsWith("style.css") || uri.endsWith("index.html")){
//            chain.doFilter(req, resp);
//        }
        if (session != null && session.getAttribute("user") == null && !(uri.endsWith("auth"))) {
            System.out.println("Not found session");
            response.sendRedirect("auth");
        } else if (session != null && session.getAttribute("user") != null && uri.endsWith("auth")) {
            response.sendRedirect("main");
        }
        else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
