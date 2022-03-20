package threads;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class ServerThreadMassage extends Thread {
    Socket clientSocket;
    private BufferedReader in; // поток чтения из сокета
    private String name;
    private BufferedWriter out;
    private final Queue<ServerThreadMassage> serverThreadMassages;
    public Map<String, List<String>> massages;

    public ServerThreadMassage(Socket clientSocket, Queue<ServerThreadMassage> serverThreadMassages) {
        this.clientSocket = clientSocket;
        this.serverThreadMassages = serverThreadMassages;
        massages = new HashMap<>();
    }

    public void run() {
        try {
            try {

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                out.write("Enter your name: " + "\n");
                out.flush();

                name = in.readLine();
                startReadMassage();

                while (true) {

                    out.write("Can you send massage: " + "\n");
                    out.flush();

                    String massageFromClient = in.readLine();
                    if ("quit".equals(massageFromClient))
                    {
                        break;
                    }

                    String[] ma = massageFromClient.split(";");
                    sendMassage(ma[0],ma[1]);

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

    private void sendMassage(String name,String massage) throws IOException {
        // if user send message to himself ...
        if (name.equals(this.name))
        {
            out.write(name+";["+massage+"]" + "\n");
            out.flush();
            return;
        }
        for (ServerThreadMassage s:serverThreadMassages) {
            if (s.name.equals(name))
            {
                if (s.massages.containsKey(name))
                {
                    s.massages.get(name).add(massage);
                }
                else
                {
                    List<String> mass = new ArrayList<>();
                    mass.add(massage);
                    s.massages.put(this.name,mass);
                }
                s.startReadMassage();
               return;
            }
        }
        out.write( "User : \""+name+"\" not found in the system!!" + "\n");
        out.flush();
    }

    private void startReadMassage() throws IOException {
        for (String name : massages.keySet()) {
            String value = massages.get(name).toString();
            try {
                out.write("*NEW MASSAGE* { "+name + ";" + value + " }\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        massages.clear();
    }
}
