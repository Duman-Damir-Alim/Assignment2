package assignment2.Servlets.Networking;

import assignment2.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * here we get side and call methods from Game, then return board to Server TODO
 */

@WebServlet(name = "ClientServlet")
public class ClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String side = user.getSide();
        int startX = Integer.parseInt(request.getParameter("startX"));
        int startY = Integer.parseInt(request.getParameter("startY"));
        int endX = Integer.parseInt(request.getParameter("endX"));
        int endY = Integer.parseInt(request.getParameter("endY"));
        Socket client = new Socket(InetAddress.getLocalHost(), 8189);
        PrintWriter pr = new PrintWriter(client.getOutputStream());
        InputStreamReader in = new InputStreamReader(client.getInputStream());
        BufferedReader bf = new BufferedReader(in);



        in.close();
        client.close();
    }
}
