package com.app;


import com.app.Threads.ClientThread;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
            // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {

                clientSocket = new Socket("127.0.0.1", 9999);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));


                ClientThread clientThread = new ClientThread(clientSocket);


                clientThread.start();

                while (clientThread.isAlive()) {
                        String  word = reader.readLine();
                        out.write(word + "\n");
                        out.flush();
                }
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
                reader.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}