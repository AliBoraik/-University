package handler;

import dis.HTTPRequest;
import dis.HTTPResponse;

import java.io.IOException;

public interface RequestHandler {
    void process(HTTPRequest request, HTTPResponse response) throws IOException;
}
