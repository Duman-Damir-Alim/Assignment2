package assignment2.Servlets.Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(1234);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ip_add = InetAddress.getByName("localhost");
        byte c[] = new byte[1024];
        byte d[] = new byte[1024];
        while (true) {
            DatagramPacket packet2 = new DatagramPacket(d, d.length);
            server.receive(packet2);
            String str = new String(packet2.getData());
            System.out.println(str);
            InetAddress ip_add1 = packet2.getAddress();
            int port = packet2.getPort();
            String send = input.readLine();
            c = send.getBytes();
            DatagramPacket packet3 = new DatagramPacket(c, c.length, ip_add1, port);
            server.send(packet3);
        }
    }
}
