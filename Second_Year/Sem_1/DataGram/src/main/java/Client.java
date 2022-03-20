import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static InetAddress ipAddress;
    private static DatagramSocket socket;

    public static void main(String[] args) throws IOException {
        socket = new DatagramSocket();
        ipAddress = InetAddress.getByName("localhost");

        while (true) {
            String massage = new Scanner(System.in).next().trim();

            sendData(massage.getBytes());
        }

    }

    public static void sendData(byte[] data) {

        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 7081);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
