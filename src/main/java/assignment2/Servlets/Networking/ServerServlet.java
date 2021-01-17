package assignment2.Servlets.Networking;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerServlet {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8189);
        Socket s = ss.accept();
        System.out.println("Client connected");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        PrintWriter pr = new PrintWriter(s.getOutputStream());


        ss.close();
        s.close();
        in.close();
    }
}
