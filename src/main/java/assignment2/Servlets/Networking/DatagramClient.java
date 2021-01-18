package assignment2.Servlets.Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket client = new DatagramSocket();
        InetAddress ip_add = InetAddress.getByName("localhost");
        byte b[] = new byte[1024];
        byte c[] = new byte[1024];
        String str = input.readLine();
        b = str.getBytes();
        DatagramPacket packet = new DatagramPacket(b, b.length, ip_add, 1234);
        client.send(packet);
        DatagramPacket packet4 = new DatagramPacket(c, c.length);
        String receive_str = new String(packet4.getData());
        System.out.println(receive_str);
        client.close();
    }
}
