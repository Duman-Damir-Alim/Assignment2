package assignment2.Servlets;

import assignment2.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthServlet")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String side = request.getParameter("side");
        if (username.equals("")){
            request.setAttribute("error", "Username cannot be empty");
            request.getRequestDispatcher("./jsp/assignment2/auth.jsp").forward(request, response);
        }
        if (username.length() > 5){
            request.setAttribute("error", "Username less than 5 characters");
            request.getRequestDispatcher("./jsp/assignment2/auth.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", new User(username, side));
        response.sendRedirect("chess");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./jsp/assignment2/auth.jsp").forward(request, response);
    }
}
