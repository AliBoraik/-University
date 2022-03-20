package com.app;


import com.app.Threads.ServerThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket server; // сервер

    public static void main(String[] args) throws IOException {
        try {
            server = new ServerSocket(9999);
            System.out.println("Сервер запущен!");
            int maximum = 10;
            int minimum = 1;
            int randomNumber = minimum + (int)(Math.random() * maximum); // random number between 1 and 10

            while (true) {
                System.out.println("Waiting for connection...");
                //сокет для общения

                Socket clientSocket = server.accept();

                System.out.println("connected ..");

                ServerThread t = new ServerThread(clientSocket,randomNumber);
                t.start();
            }
        }finally {
            System.out.println("Сервер закрыт!");
            server.close();
        }
    }
}