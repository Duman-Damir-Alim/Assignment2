package assignment2.Servlets.Networking;

import assignment2.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * here we get side and call methods from Game, then return board to Server TODO
 */

@WebServlet(name = "ClientServlet")
public class ClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String side = user.getSide();

        try (Socket socket = new Socket()) {
            //socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8189));
            //TODO
        }
    }

    public static void main(String[] args) {

    }
}
