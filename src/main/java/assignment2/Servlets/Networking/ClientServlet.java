package assignment2.Servlets.Networking;

import assignment2.User;
import assignment2.model.Game;
import assignment2.model.Player;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.InetAddress;
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
//        Socket client = new Socket(InetAddress.getLocalHost(), 8189);
//        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
//        PrintWriter pr = new PrintWriter(client.getOutputStream());
//        InputStreamReader in = new InputStreamReader(client.getInputStream());
//        BufferedReader bf = new BufferedReader(in);

        Player player = new Player(side.equals("white"));
        Game game = new Game();
        game.initialize(player);
        try {
            System.out.println(game.getBoard().getBox(5, 1).getX());
            System.out.println(game.getBoard().getBox(5, 1).getY());
            System.out.println(game.getBoard().getBox(1, 5).getPiece());
            game.playerMove(player, startX, startY, endX, endY);
            request.setAttribute("board", game.getBoard());
            //output.writeObject(game.getBoard()); //sending data to server
            request.getRequestDispatcher("./jsp/assignment2/chess.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

//        in.close();
//        client.close();
    }
}
