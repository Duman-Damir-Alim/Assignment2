package assignment2.Servlets.Networking;


import assignment2.model.Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8189);
        Socket s = ss.accept();
        System.out.println("Client connected");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());


        ss.close();
        s.close();
        in.close();
    }
}
