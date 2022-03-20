package handler;

import dis.HTTPRequest;
import dis.HTTPResponse;

import java.io.IOException;

public class HomeHandler implements RequestHandler{
    @Override
    public void process(HTTPRequest request, HTTPResponse response) throws IOException {

        String body = getBodyHome(request);

        response.sendResponse(body,"200 OK");

    }


    private String getBodyHome(HTTPRequest request){
        String body = "<!DOCTYPE html>\n" +
                "<html lang=\"en\" >\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "<link rel=\"stylesheet\" href=\"./style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"form\">\n" +
                "<div class=\"tab-content\">\n" +
                "<div id=\"login\">\n" +
                "<h1>Welcome</h1>\n" +
                "<form action=\"/\" method=\"GET\">\n" +
                "<div class=\"field-wrap\">\n" +
                "<label>\n" +
                "First Name : "+request.getSession().getFirst_Name()+"<span class=\"req\"></span>\n" +
                "</label>\n" +
                "<br >\n" +
                "</div>\n" +
                " <div class=\"field-wrap\">\n" +
                "<label>\n" +
                " Last Name : "+request.getSession().getLast_Name()+"<span class=\"req\"></span>\n" +
                "</label>\n" +
                "<br >\n" +
                "</div>\n" +
                " <div class=\"field-wrap\">\n" +
                "<br >\n" +
                "</div>\n" +
                "<button class=\"button button-block\"/>Long out</button>\n" +
                "</form>\n" +
                "</div>\n" +
                "<div id=\"signup\">\n" +
                "<h1>Sign Up for Free</h1>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";



        return body;
    }
}
