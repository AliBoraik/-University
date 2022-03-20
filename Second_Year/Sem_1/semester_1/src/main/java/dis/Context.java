package dis;

import handler.FilesHandler;
import handler.RequestHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Context {

    //resource handlers
    private final Map<String, RequestHandler> handlerMap = new HashMap<>();


    private final Map<String, Session> sessionMap ;



    public void setContext(String path , RequestHandler requestHandler){
        handlerMap.put(path, requestHandler);
    }

    public Context() {
        sessionMap = new HashMap<>();
    }



    public RequestHandler getContextHandler(String path){


        if (handlerMap.containsKey(path))
            return handlerMap.get(path);

        if (path.equals("/")|| path.equals("/?"))
            return handlerMap.get("/index");

        if (path.equals("/signup"))
            return handlerMap.get("/home");


        if(path.endsWith(".css") || path.endsWith(".js") || path.endsWith("html"))
            return new FilesHandler("");

        return handlerMap.get("/notFound");
    }



    public Map<String, Session> getSessionMap() {
        return sessionMap;
    }


    public Pair<String,Session> getSessionByEmail(String email) {
        for (String k:sessionMap.keySet()) {
            if (Objects.equals(sessionMap.get(k).getEmail_Address(), email)) {
                return new Pair<>(k, sessionMap.get(k));
            }
        }
        return null;
    }

    public static class Pair<A,B> {
        public final A a;
        public final B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }


}
