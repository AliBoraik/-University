package com.app.Threads;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket clientSocket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out;
    private final int randomNumber;

    public ServerThread(Socket clientSocket, int randomNumber) {
        this.clientSocket = clientSocket;
        this.randomNumber = randomNumber;
    }

    public void run() {
        try {

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                out.write("Введите число от 1 до 10" + "\n");
                out.flush();

                int t = 3;
                while (t != 0) {
                    String massageForClient;

                    int numberFromClient = Integer.parseInt(in.readLine()); // ждём пока клиент что-нибудь нам напишет

                    if (numberFromClient >= 1 && numberFromClient <= 10) {

                        if (numberFromClient == randomNumber) {
                            massageForClient = "правильный ответ";
                            out.write(massageForClient + "\n"); // send message to client
                            out.flush();
                            break;

                        } else {
                            massageForClient = "не правильный ответ !!";
                            if (t - 1 == 0) {
                                massageForClient += " , попытки окончены ...";
                            } else
                                massageForClient += " , попробуйте ешё рфз ..";

                            out.write(massageForClient + "\n");
                            out.flush(); // выталкиваем все из буфера
                            // потоки тоже хорошо бы закрыть
                        }
                    }else{
                        massageForClient = "Номер неверный ....";
                        out.write(massageForClient + "\n"); // send message to client
                        out.flush();
                    }
                    t--;
                }
            }finally {
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
