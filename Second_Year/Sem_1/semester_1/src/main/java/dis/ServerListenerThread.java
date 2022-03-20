package dis;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ServerListenerThread extends Thread {
    private final Socket clientSocket;
    private final OutputStream out;
    private final Context context;

    public ServerListenerThread(Socket clientSocket,Context context) throws IOException {
        this.clientSocket = clientSocket;
        this.out = clientSocket.getOutputStream();
        this.context = context;

    }

    @Override
    public void run() {
        try {
            try {
                HTTPRequest request = new HTTPRequest(clientSocket.getInputStream());

                HTTPResponse response = new HTTPResponse(clientSocket.getOutputStream());

                if (request.getPath().equals("/?")){
                    // remove cookie
                    response.addCookies("user","",0);
                    request.getCookies().clear();
                }

                HashMap<String, String> idSession = request.getCookies();

                if (idSession != null && idSession.size() != 0){
                    request.setSession(context.getSessionMap().get(idSession.get("user")));
                    if (request.getPath().equals("/")) {
                        request.setPath("/home");
                    }
                }

                if (request.getPath().equals("/signup")) {
                    setNewAccountToContext(request,response);
                }

                if (request.getPath().equals("/login")) {
                    singInTheSystem(request,response);
                }

                context.getContextHandler(request.getPath()).process(request, response);
            } finally {
                out.close();
                clientSocket.close();
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    private void singInTheSystem(HTTPRequest request, HTTPResponse response) {
        Context.Pair<String, Session> s = context.getSessionByEmail(request.getSession().getEmail_Address());
        if (s != null && s.b.getPassword().equals(request.getSession().getPassword())){
            String id = s.a;
            response.addCookies("user",id);
            request.setSession(s.b);
            request.setPath("/home");
        }else {
            request.setPath("/notFoundUser");
        }
    }

    private void setNewAccountToContext(HTTPRequest request, HTTPResponse response) {
        String id = request.getRandomId();
        response.addCookies("user",id);
        context.getSessionMap().put(id, request.getSession());
        request.setPath("/home");
    }
}
