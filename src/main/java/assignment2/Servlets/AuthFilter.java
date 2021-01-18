package assignment2.Servlets;

import assignment2.helper.SharedCharArrayToCheckURL;
import assignment2.helper.URLFindNotifier;
import assignment2.helper.URLFindWaiter;

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
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("OUR URI " + uri);
        if (session != null && session.getAttribute("user") == null && !(uri.endsWith("auth"))) {
            System.out.println("Not found session");
            String fullURL = getFullURL(request);
            SharedCharArrayToCheckURL sharedCharArrayToCheckURL = new SharedCharArrayToCheckURL(5);
            URLFindWaiter waiter = new URLFindWaiter(sharedCharArrayToCheckURL);
            new Thread(waiter, "waiter").start();
            URLFindNotifier notifier = new URLFindNotifier(fullURL, sharedCharArrayToCheckURL);
            new Thread(notifier, "notifier").start();
            resp.getWriter().write("Unauthorized user request");
        }else if (session != null && session.getAttribute("user") != null && uri.endsWith("auth")) {
            response.sendRedirect("main");
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public static String getFullURL(HttpServletRequest request) {
        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
