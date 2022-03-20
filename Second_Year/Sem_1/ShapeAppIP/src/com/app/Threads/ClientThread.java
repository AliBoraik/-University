package com.app.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {
    private final BufferedReader in;

    public ClientThread(Socket socket) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {

        while (true) {
            try {
                String massage = in.readLine();
                if (massage == null)
                {
                    break;
                }
                System.out.println(massage);

                if (massage.equals("правильный ответ")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
