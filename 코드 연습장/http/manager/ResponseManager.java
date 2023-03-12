package http.manager;

import http.dto.RequestDto;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ResponseManager {
    Socket socket;
    RequestDto request;

    public ResponseManager(Socket socket, RequestDto request) {
        this.socket = socket;
        this.request = request;
    }

    public void writeResponse() throws IOException {
        PrintStream response = new PrintStream(socket.getOutputStream());
        response.println("HTTP/1.1 200 OK");
        response.println("Content-type: text/html");
        response.println();

        if(request.getUri().contains("today")) {
            response.println(new Date());
        } else {
            response.println("It is working");
        }
        response.flush();
        response.close();
    }
}
