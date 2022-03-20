package dis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HTTPResponse {

    private int responseCode = 200;
    private OutputStream outputStream;

    // cookies to be sent to client
    private  Map<String,String> cookies;

    public void addCookies(String user,String value,int MaxAge){
        cookies.put(user,value+"; Max-Age="+MaxAge);
    }

    public void addCookies(String user,String value){
        cookies.put(user,value);
    }


    public HTTPResponse(OutputStream outputStream) throws IOException {
        this.outputStream = outputStream;
        cookies = new HashMap<>();
    }

    public void sendResponse(String body,String responseCode) throws IOException {

        final String CRLF = "\n\r";
        String http =
                "HTTP/1.1 "+ responseCode + CRLF +   // status line  + CRLF
                        "Content-Length: " + body.getBytes(StandardCharsets.UTF_8).length + CRLF +   // Size the massage (html)
                       getCookiesToString()
                        +CRLF +
                        body ;

        outputStream.write(http.getBytes());
        outputStream.flush();

    }

    private String getCookiesToString() {
        StringBuilder c = new StringBuilder();
     //   cookies.forEach((key, tab) -> /* do something with key and tab */);
        cookies.forEach((k,v) -> c.append("Set-Cookie: ").append(k).append("=").append(v).append("\n\r"));
        return c.toString();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
