import threads.ServerThreadMassage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
    private static ServerSocket server; // сервер
    public static Queue<ServerThreadMassage> userThreads;
    public static void main(String[] args) throws IOException {
        System.out.println("sdfghjhgfds");

        try {
            server = new ServerSocket(9999);
            System.out.println("Сервер запущен!");
            userThreads = new LinkedList<>();

            while (true) {
                System.out.println("Waiting for connection...");
                //сокет для общения

                Socket clientSocket = server.accept();

                System.out.println("connected ..");

                ServerThreadMassage t = new ServerThreadMassage(clientSocket,userThreads);
                t.start();
                userThreads.add(t);
            }
        }finally {
            System.out.println("Сервер закрыт!");
            server.close();
        }
    }
}
