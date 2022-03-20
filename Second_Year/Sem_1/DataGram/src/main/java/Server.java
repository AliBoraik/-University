import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 7081;
        DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName("localhost"));

        while (true) {

            byte[] data = new byte[512];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
                int size = packet.getLength();
                System.out.println(new String(packet.getData(),0,size));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
