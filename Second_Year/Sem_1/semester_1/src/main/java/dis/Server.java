package dis;

import handler.HomeHandler;
import handler.NotFoundUser;
import handler.NotFoundError;
import handler.HandlerLongIn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket server;
    public static void main(String[] args) throws IOException {
        int port = 8080;
        try {

            Context context = new Context();
            context.setContext("/index",new HandlerLongIn());
            context.setContext("/notFound",new NotFoundError());
            context.setContext("/notFoundUser",new NotFoundUser());
            context.setContext("/home",new HomeHandler());


            server = new ServerSocket(port);
            System.out.println("The server is working..");
            while (true) {

                Socket clientSocket = server.accept();

                ServerListenerThread tc = new ServerListenerThread(clientSocket,context);
                tc.start();
            }
        }finally {
            System.out.println("dis.Server closed!");
            server.close();

        }
    }
}
