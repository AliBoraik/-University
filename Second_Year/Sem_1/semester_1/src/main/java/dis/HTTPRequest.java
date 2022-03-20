package dis;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class HTTPRequest {

    private InputStream inputStream;

    private String method ;
    private String httpVersion;
    private String path ;

    private Session session;

    // cookies
    private HashMap<String,String> cookies = null;

    public HashMap<String, String> getCookies() {
        return cookies;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    private int contentLength = 0;


    public HTTPRequest(InputStream inputStream) throws Throwable {
        this.inputStream = inputStream;
        readInputHeaders();
    }

    public void readInputHeaders() throws Throwable {

        String line;
        // first line
        StringBuilder firsLine = new StringBuilder();
        char l;
        while ((l = (char) inputStream.read()) != '\n'){
            firsLine.append(l);
        }
        setParameter(firsLine.toString());

        while (inputStream.available() > 0){
            // read line
            line = readLine();

            String c_l = "Content-Length: ";
            if (line.contains(c_l)) {
                contentLength = Integer.parseInt(line.substring(c_l.length(), c_l.length() + 2));
                if (contentLength == 0)
                    break;
                while (inputStream.available() > contentLength) {
                    inputStream.read();
                    }
                setSession();
                break;
            }

            if (line.startsWith("Cookie: ")){
             setCookiesFromHeader(line);
            }
        }


        if ((path.equals("/signup") || path.equals("/login")) && session == null){
            path = "/index";
        }
    }

    public void setCookiesFromHeader(String line) {
        cookies = new HashMap<>();
        String[] cookie = line.substring(8).trim().split("=");
        cookies.put(cookie[0],cookie[1]);
    }

    private String readLine() throws IOException {
        StringBuilder firsLine = new StringBuilder();
        char l;
        while ((l = (char) inputStream.read()) != '\n'){
            firsLine.append(l);
        }
        return firsLine.toString();
    }

    private void setSession() throws IOException {
        char l;
        StringBuilder f = new StringBuilder();
        while (inputStream.available() > 0){
            l = (char) inputStream.read();

            f.append(l);
        }
        session = new Session();
        session.setValues(f.toString());

    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private void setParameter(String s) {
        String[] l = s.split(" ");
        method = l[0];
        path = l[1].trim();
        httpVersion = l[2];
       //System.out.println(path);

    }
    public String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
